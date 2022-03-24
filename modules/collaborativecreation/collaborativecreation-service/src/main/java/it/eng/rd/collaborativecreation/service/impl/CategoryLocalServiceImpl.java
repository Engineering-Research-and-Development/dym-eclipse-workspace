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

package it.eng.rd.collaborativecreation.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import it.eng.rd.collaborativecreation.exception.NoSuchCategoryException;
import it.eng.rd.collaborativecreation.exception.NoSuchHashtagException;
import it.eng.rd.collaborativecreation.model.Category;
import it.eng.rd.collaborativecreation.model.Hashtag;
import it.eng.rd.collaborativecreation.service.base.CategoryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.CategoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see CategoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Category addCategory(
			long challengeId,
			String name,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("CategoryLocalServiceImpl - addCategory method");

		
		long categoryId = counterLocalService.increment();

		Category category = categoryPersistence.create(categoryId);

		category.setCategoryId(categoryId);
		category.setChallengeId(challengeId);
		category.setName(name);
		
		_log.info("challengeId: " +challengeId);
		_log.info("name: " +name);
		
		category = categoryPersistence.update(category);
		
		return category;
	}
	
	public Category getCategory(long challengeId, String name) throws PortalException {
    	_log.info("CategoryLocalServiceImpl - getCategoryByName method");
		_log.info("challengeId "+challengeId);
		_log.info("name "+name);
		
		try {
			return categoryPersistence.findByName(challengeId, name);
		} catch (NoSuchCategoryException e) {
			return null;
		}
    }
	
	public List<Category> getCategoriesByChallengeId(long challengeId) throws PortalException {
    	_log.info("CategoryLocalServiceImpl - getCategoriesByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		return categoryPersistence.findByChallenge(challengeId);
    }
	
	public void deleteCategoriesByChallengeId(long challengeId) throws PortalException {
		_log.info("CategoryLocalServiceImpl - deleteCategoriesByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		categoryPersistence.removeByChallenge(challengeId);
    }
	
	private static final Log _log = LogFactoryUtil.getLog(CategoryLocalServiceImpl.class);
}