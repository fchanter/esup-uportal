/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.portal.xml;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;

import org.springframework.core.io.Resource;

/**
 * Defines commonly used XML and XSLT utilities
 * 
 * @author Eric Dalquist
 * @version $Revision$
 */
public interface XmlUtilities {
    /**
     * Get {@link Templates} for the specified stylesheet resource
     */
    public Templates getTemplates(Resource stylesheet) throws TransformerConfigurationException, IOException;
    
    /**
     * Get a {@link Transformer} for the specified stylesheet resource
     */
    public Transformer getTransformer(Resource stylesheet) throws TransformerConfigurationException, IOException;
    
    /**
     * Gets an appropriate cache key for the specified stylesheet resource. The key should be valid for both {@link Transformer}s
     * and {@link Templates} based on this stylesheet.
     */
    public Serializable getStylesheetCacheKey(Resource stylesheet) throws TransformerConfigurationException, IOException;
    
    /**
     * @return The {@link XMLEventFactory} used for generating StAX events
     */
    public XMLEventFactory getXmlEventFactory();
    
    /**
     * Converts an XMLEvent to a human readable string
     */
    public String xmlEventToString(XMLEvent event);
    
    /**
     * Converts the state of an XMLStreamReader to a String
     */
    public String streamStateToString(XMLStreamReader streamReader);
}
