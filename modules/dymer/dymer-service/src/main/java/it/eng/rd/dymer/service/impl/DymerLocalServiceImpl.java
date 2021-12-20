/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.rd.dymer.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.service.base.DymerLocalServiceBaseImpl;

/**
 * The implementation of the dymer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.dymer.service.DymerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see DymerLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.dymer.model.Dymer",
	service = AopService.class
)
public class DymerLocalServiceImpl extends DymerLocalServiceBaseImpl {

	
	@Indexable(type = IndexableType.REINDEX)
	public Dymer addDymer(long userId, String name,
			ServiceContext serviceContext) throws PortalException {

		_log.info("DymerLocalServiceImpl, addDymer method");
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		//validate(name);

		long dymerId = counterLocalService.increment();

		Dymer dymer = dymerPersistence.create(dymerId);

		dymer.setUuid(serviceContext.getUuid());
		dymer.setUserId(userId);
		dymer.setGroupId(groupId);
		dymer.setCompanyId(user.getCompanyId());
		dymer.setUserName(user.getFullName());
		dymer.setCreateDate(serviceContext.getCreateDate(now));
		dymer.setModifiedDate(serviceContext.getModifiedDate(now));
		dymer.setName(name);
		dymer.setExpandoBridgeAttributes(serviceContext);
		
		_log.info("uuid: " +serviceContext.getUuid());
		_log.info("userId: " +userId);
		_log.info("groupId: " +groupId);
		_log.info("companyId: " +user.getCompanyId());
		_log.info("userName: " +user.getFullName());
		_log.info("createDate: " +now.toString());
		_log.info("modifiedDate: " +now.toString());
		_log.info("name: " +name);

		dymerPersistence.update(dymer);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, dymer.getCreateDate(),
                dymer.getModifiedDate(), Dymer.class.getName(),
                dymerId, dymer.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, dymer.getName(), null, null, null,
                null, 0, 0, null);
		
		_log.info("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		_log.info("generated updateLink");
		// permission
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Dymer.class.getName(), dymerId, false, true, true);
		
		_log.info("generated permissions");

		return dymer;
	}
	
	public List<Dymer> getDymers(long groupId) {

		return dymerPersistence.findByGroupId(groupId);
	}

	public List<Dymer> getDymers(long groupId, int start, int end,
			OrderByComparator<Dymer> obc) {

		return dymerPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<Dymer> getDymers(long groupId, int start, int end) {

		return dymerPersistence.findByGroupId(groupId, start, end);
	}

	public int getDymersCount(long groupId) {

		return dymerPersistence.countByGroupId(groupId);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerLocalServiceImpl.class);
	
//	protected void validate(String name) throws PortalException {
//		if (Validator.isNull(name)) {
//			throw new DymerNameException();
//		}
//	}
}