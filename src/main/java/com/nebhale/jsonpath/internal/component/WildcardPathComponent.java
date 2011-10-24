/*
 * Copyright 2011 the original author or authors.
 *
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
 */

package com.nebhale.jsonpath.internal.component;

import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;

/**
 * A {@link PathComponent} that handles wildcards
 * <p />
 * 
 * <strong>Concurrent Semantics</strong><br />
 * 
 * Thread-safe
 */
public final class WildcardPathComponent extends AbstractChainedPathComponent {

    public WildcardPathComponent(PathComponent delegate) {
        super(delegate);
    }

    @Override
    protected JsonNode select(JsonNode input) {
        if (input.isArray()) {
            return input;
        } else {
            ArrayNode result = JsonNodeFactory.instance.arrayNode();

            for (Iterator<JsonNode> i = input.getElements(); i.hasNext();) {
                result.add(i.next());
            }

            return result;
        }
    }

}
