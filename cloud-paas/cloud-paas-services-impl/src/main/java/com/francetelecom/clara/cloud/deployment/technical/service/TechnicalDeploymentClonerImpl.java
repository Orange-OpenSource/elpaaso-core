/**
 * Copyright (C) 2015 Orange
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.francetelecom.clara.cloud.deployment.technical.service;

import com.francetelecom.clara.cloud.deployment.common.service.ModelItemClonerXstreamImpl;
import com.francetelecom.clara.cloud.model.TechnicalDeployment;

/**
 * Technical Deployment duplication factory. Takes a complete TD, and create a
 * transient detached copy - adjsting name with a prefix (all ModelItemName) to
 * avoid unique constraint conflict - resetting id and version
 * 
 * Impl is based on xstream marshalling + regex pattern + xstream unmarshalling
 * 
 * 
 * @author APOG7416
 * 
 */
public class TechnicalDeploymentClonerImpl extends ModelItemClonerXstreamImpl<TechnicalDeployment> implements TechnicalDeploymentCloner {

}
