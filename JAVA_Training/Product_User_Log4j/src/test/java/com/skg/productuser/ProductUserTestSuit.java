package com.skg.productuser;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ FileExistsOrNot.class, FileExistsContentOrNot.class, UserCSVReaderTest.class,
		ProductCSVReaderTest.class, ProductAvailabilityServiceTest.class,

})

public class ProductUserTestSuit {
	// This class remains empty, it is used only as a holder for the above
	// annotations
}
