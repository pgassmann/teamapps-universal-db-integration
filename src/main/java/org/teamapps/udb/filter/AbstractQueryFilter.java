/*-
 * ========================LICENSE_START=================================
 * TeamApps.org UniversalDB Integration
 * ---
 * Copyright (C) 2020 TeamApps.org
 * ---
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package org.teamapps.udb.filter;

import org.teamapps.universaldb.index.ColumnIndex;
import org.teamapps.universaldb.index.TableIndex;
import org.teamapps.universaldb.query.Filter;

public abstract class AbstractQueryFilter {

	private final String fieldName;

	public AbstractQueryFilter(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public abstract FilterType getType();

	public abstract Object getFilterDefinition();

	public Filter createFilter(TableIndex tableIndex) {
		ColumnIndex columnIndex = tableIndex.getColumnIndex(getFieldName());
		return columnIndex.createFilter(getFilterDefinition());
	}
}
