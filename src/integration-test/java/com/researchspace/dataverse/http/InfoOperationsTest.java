/*
 * 
 */
package com.researchspace.dataverse.http;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.researchspace.dataverse.entities.DataverseResponse;
import com.researchspace.dataverse.entities.DvMessage;
/** <pre>
Copyright 2016 ResearchSpace

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
</pre>
*/
public class InfoOperationsTest extends AbstractIntegrationTest {

	private static final String NEW_TEXT = "Do you want to publish";

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSetDatasetPublishPopupCustomText() {
		DvMessage originalText = infoOps.getDatasetPublishPopupCustomText();
		assertTrue("Message text was empty", !StringUtils.isEmpty(originalText.getMessage()));
		DataverseResponse<Object> response = infoOps.setDatasetPublishPopupCustomText(NEW_TEXT);
		assertTrue("New text was not set", response.getData().toString().contains(NEW_TEXT));
	    response = infoOps.setDatasetPublishPopupCustomText(originalText.getMessage());
	    assertTrue("Originl text was not restored", response.getData().toString().contains(originalText.getMessage()));		
	}

}
