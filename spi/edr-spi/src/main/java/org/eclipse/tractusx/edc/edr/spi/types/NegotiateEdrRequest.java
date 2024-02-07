/********************************************************************************
 * Copyright (c) 2023 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.tractusx.edc.edr.spi.types;

import org.eclipse.edc.spi.types.domain.callback.CallbackAddress;
import org.eclipse.edc.spi.types.domain.offer.ContractOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NegotiateEdrRequest {

    private String connectorAddress;
    private String protocol = "ids-multipart";
    private String connectorId;
    private ContractOffer offer;

    private List<CallbackAddress> callbackAddresses = new ArrayList<>();

    private NegotiateEdrRequest() {

    }

    public String getConnectorAddress() {
        return connectorAddress;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getConnectorId() {
        return connectorId;
    }


    public List<CallbackAddress> getCallbackAddresses() {
        return callbackAddresses;
    }

    public ContractOffer getOffer() {
        return offer;
    }


    public static final class Builder {
        private final NegotiateEdrRequest entity;

        private Builder() {
            entity = new NegotiateEdrRequest();
        }

        public Builder connectorAddress(String connectorAddress) {
            entity.connectorAddress = connectorAddress;
            return this;
        }

        public Builder protocol(String protocol) {
            entity.protocol = protocol;
            return this;
        }

        public Builder connectorId(String connectorId) {
            entity.connectorId = connectorId;
            return this;
        }

        public Builder offer(ContractOffer offer) {
            entity.offer = offer;
            return this;
        }

        public Builder callbackAddresses(List<CallbackAddress> callbackAddresses) {
            entity.callbackAddresses = callbackAddresses;
            return this;
        }

        public NegotiateEdrRequest build() {
            Objects.requireNonNull(entity.protocol, "protocol should not be null");
            Objects.requireNonNull(entity.connectorAddress, "connector address should not be null");
            Objects.requireNonNull(entity.offer, "offer should not be null");
            return entity;
        }

        public static Builder newInstance() {
            return new Builder();
        }
    }
}
