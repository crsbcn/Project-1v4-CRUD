package com.proj90.test;


import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.proj90.utils.ConnectionFactory;

public class ConnectionFactoryTest {
	@Test
	public void connectionFactory_ShouldProduceValidConnections() {
		assertNotNull(ConnectionFactory.getConnection());
	}
}
