/**
 * Copyright (c) 2022 Bosch.IO GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.dmf.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JSON representation of confirm request.
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DmfConfirmRequest extends DmfActionRequest {

    @JsonProperty
    private String targetSecurityToken;

    @JsonProperty
    private List<DmfSoftwareModule> softwareModules;

    public String getTargetSecurityToken() {
        return targetSecurityToken;
    }

    public void setTargetSecurityToken(final String targetSecurityToken) {
        this.targetSecurityToken = targetSecurityToken;
    }

    public List<DmfSoftwareModule> getSoftwareModules() {
        if (softwareModules == null) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(softwareModules);
    }

    /**
     * Add a Software module.
     *
     * @param createSoftwareModule
     *            the module
     */
    public void addSoftwareModule(final DmfSoftwareModule createSoftwareModule) {
        if (softwareModules == null) {
            softwareModules = new ArrayList<>();
        }

        softwareModules.add(createSoftwareModule);

    }
}
