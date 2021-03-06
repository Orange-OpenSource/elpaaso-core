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
package com.francetelecom.clara.cloud.logicalmodel.samplecatalog;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.francetelecom.clara.cloud.logicalmodel.CFJavaProcessing;
import com.francetelecom.clara.cloud.logicalmodel.LogicalDeployment;
import com.francetelecom.clara.cloud.logicalmodel.LogicalServiceAccessTypeEnum;
import com.francetelecom.clara.cloud.logicalmodel.LogicalWebGUIService;

/**
 * JEE Probe LogicalModel Sample : a single execution node with only one web gui service
 */
public class SimpleProbeLogicalModelCatalog extends BaseReferenceLogicalModelsCatalog {

    String APP_CODE = "simple-probe";

    @Override
    public LogicalDeployment createLogicalModel(String logicalModelName, LogicalDeployment existingLDToUpdate) {

        if (existingLDToUpdate == null) {
            existingLDToUpdate = new LogicalDeployment();
        }

		LogicalWebGUIService webGui = createLogicalWebGuiService("SimpleProbeWebUI", APP_CODE, true, false, 1, 20, ArtefactType.jar);
		CFJavaProcessing javaProcessing = createCFJavaProcessing(this, "SProbeExecNode", APP_CODE, ArtefactType.jar);

        existingLDToUpdate.addLogicalService(webGui);
		existingLDToUpdate.addExecutionNode(javaProcessing);

		javaProcessing.addLogicalServiceUsage(webGui, LogicalServiceAccessTypeEnum.NOT_APPLICABLE);

        return existingLDToUpdate;
    }

    /**
	 * @param baseUrl  Correspond to the context root of the EAR to test. Can be use to
	 *          filter multiples EAR tests. Ignore it if you just have one EAR.
	 * @return list of urls and corresponding keywords used to check application
	 *         deployment
	 */
	@Override
	public Map<String, String> getAppUrlsAndKeywords(URL baseUrl) {
		HashMap<String, String> urls = new HashMap<String, String>();
		urls.put("/", "Paas Probe");
		return urls;
	}

    @Override
    public boolean isInstantiable() {
        return true;
    }

    @Override
    public String getAppDescription() {
        return "MySimpleProbeSample description";
    }

    @Override
    public String getAppCode() {
        return "MySimpleProbeSampleCODE";
    }

    @Override
    public String getAppLabel() {
        return "MySimpleProbeSample";
    }

    @Override
    public String getAppReleaseDescription() {
        return "MySimpleProbeSample release description";
    }

    @Override
    public String getAppReleaseVersion() {
        return "G01R01";
    }

}
