package com.webstack.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.webstack.test.common")
@DisplayName("Common Test")
//@IncludeTags({"development","uat"})
@ExcludeTags("production")
//@ExcludePackages("com.webstack.test.utiltest")
public class TestRunner {
		
}
