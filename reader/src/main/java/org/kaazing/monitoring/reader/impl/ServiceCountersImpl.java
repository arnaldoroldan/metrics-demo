/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.monitoring.reader.impl;

import java.util.List;

import org.kaazing.monitoring.reader.agrona.extension.CountersManagerEx;
import org.kaazing.monitoring.reader.api.Counter;
import org.kaazing.monitoring.reader.api.ServiceCounters;
import org.kaazing.monitoring.reader.interfaces.MetricsCollector;

public class ServiceCountersImpl implements ServiceCounters {

    private String name;
    private MetricsCollector metricsCollector;

    public ServiceCountersImpl(String name, CountersManagerEx countersManager) {
        this.name = name;
        this.metricsCollector = new MetricsCollectorAgrona(countersManager);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Counter> getCounters() {
        return metricsCollector.getCounters();
    }

}
