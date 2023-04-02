package com.jobsity.jobsityinterview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public abstract class GenericMockitoTest {

  private AutoCloseable closeable;

  @BeforeEach
  protected void setUp() {
    closeable = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  protected void tearDown() throws Exception {
    closeable.close();
  }

}
