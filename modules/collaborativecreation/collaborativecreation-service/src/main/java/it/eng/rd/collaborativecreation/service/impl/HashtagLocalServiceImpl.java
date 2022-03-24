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

import it.eng.rd.collaborativecreation.exception.NoSuchHashtagException;
import it.eng.rd.collaborativecreation.model.Category;
import it.eng.rd.collaborativecreation.model.Hashtag;
import it.eng.rd.collaborativecreation.service.base.HashtagLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the hashtag local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.HashtagLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see HashtagLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Hashtag",
	service = AopService.class
)
public class HashtagLocalServiceImpl extends HashtagLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Hashtag addHashtag(
			long challengeId,
			String name,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("HashtagLocalServiceImpl - addHashtag method");

		
		long hashtagId = counterLocalService.increment();

		Hashtag hashtag = hashtagPersistence.create(hashtagId);

		hashtag.setHashtagId(hashtagId);
		hashtag.setChallengeId(challengeId);
		hashtag.setName(name);
		
		_log.info("challengeId: " +challengeId);
		_log.info("name: " +name);
		
		hashtag = hashtagPersistence.update(hashtag);
		
		return hashtag;
	}
	
	public Hashtag getHashtag(long challengeId, String name) throws PortalException {
    	_log.info("HashtagLocalServiceImpl - getHashtagByName method");
		_log.info("challengeId "+challengeId);
		_log.info("name "+name);
		
		try {
			return hashtagPersistence.findByName(challengeId, name);
		} catch (NoSuchHashtagException e) {
			return null;
		}
    }
	
	public List<Hashtag> getHashtagsByChallengeId(long challengeId) throws PortalException {
    	_log.info("HashtagLocalServiceImpl - getHashtagsByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		return hashtagPersistence.findByChallenge(challengeId);
    }
	
	public void deleteHashtagsByChallengeId(long challengeId) throws PortalException {
    	_log.info("HashtagLocalServiceImpl - deleteHashtagsByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		hashtagPersistence.removeByChallenge(challengeId);
    }
	
	private static final Log _log = LogFactoryUtil.getLog(HashtagLocalServiceImpl.class);
}