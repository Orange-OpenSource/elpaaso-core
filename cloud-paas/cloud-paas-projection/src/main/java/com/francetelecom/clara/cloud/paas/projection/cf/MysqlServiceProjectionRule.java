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
package com.francetelecom.clara.cloud.paas.projection.cf;

import com.francetelecom.clara.cloud.logicalmodel.LogicalDeployment;
import com.francetelecom.clara.cloud.logicalmodel.LogicalMysqlService;
import com.francetelecom.clara.cloud.model.TechnicalDeployment;
import com.francetelecom.clara.cloud.techmodel.cf.Space;
import com.francetelecom.clara.cloud.techmodel.cf.services.managed.ManagedService;

import java.util.Set;

public class MysqlServiceProjectionRule implements ServiceProjectionRule {

    @Override
    public void apply(LogicalDeployment ld, TechnicalDeployment td, ProjectionContext projectionContext) {
        // generate services
        Set<LogicalMysqlService> logicalMysqlServices = ld.listLogicalServices(LogicalMysqlService.class);
        for (LogicalMysqlService logicalMysqlService : logicalMysqlServices) {
            // generate cloud foundry service
            td.add(toMysqlService(logicalMysqlService, projectionContext.getSpace()));
        }

    }

    protected ManagedService toMysqlService(LogicalMysqlService logicalMysqlService, Space space) {
        ManagedService mysqlService = new ManagedService("p-mysql", "100mb", logicalMysqlService.getServiceName(), space);
        mysqlService.setLogicalModelId(logicalMysqlService.getName());
        return mysqlService;
    }

}
