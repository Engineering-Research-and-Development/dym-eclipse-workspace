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

package it.eng.rd.dymer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Dymer service. Represents a row in the &quot;DYM_Dymer&quot; database table, with each column mapped to a property of this class.
 *
 * @author ENGRD
 * @see DymerModel
 * @generated
 */
@ImplementationClassName("it.eng.rd.dymer.model.impl.DymerImpl")
@ProviderType
public interface Dymer extends DymerModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.rd.dymer.model.impl.DymerImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Dymer, Long> DYMER_ID_ACCESSOR =
		new Accessor<Dymer, Long>() {

			@Override
			public Long get(Dymer dymer) {
				return dymer.getDymerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Dymer> getTypeClass() {
				return Dymer.class;
			}

		};

}