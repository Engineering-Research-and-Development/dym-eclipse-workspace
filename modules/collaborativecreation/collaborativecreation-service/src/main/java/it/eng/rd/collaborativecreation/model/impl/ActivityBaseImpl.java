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

package it.eng.rd.collaborativecreation.model.impl;

import it.eng.rd.collaborativecreation.model.Activity;
import it.eng.rd.collaborativecreation.service.ActivityLocalServiceUtil;

/**
 * The extended model base implementation for the Activity service. Represents a row in the &quot;COCREATION_Activity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ActivityImpl}.
 * </p>
 *
 * @author ENGRD
 * @see ActivityImpl
 * @see Activity
 * @generated
 */
public abstract class ActivityBaseImpl
	extends ActivityModelImpl implements Activity {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a activity model instance should use the <code>Activity</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ActivityLocalServiceUtil.addActivity(this);
		}
		else {
			ActivityLocalServiceUtil.updateActivity(this);
		}
	}

}