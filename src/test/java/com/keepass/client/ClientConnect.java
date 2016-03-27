package com.keepass.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.Entry;
import de.slackspace.openkeepass.domain.Group;
import de.slackspace.openkeepass.domain.KeePassFile;

/**
 * Created by sergio on 3/27/16.
 */
public class ClientConnect {

	@Test
	public void connectTest() throws FileNotFoundException {
		FileInputStream keePassFile = new FileInputStream("target/test-classes/ambientes_ac.kdbx");
		FileInputStream keyFile = new FileInputStream("target/test-classes/ambientes_ac.key");

		// Open Database
		KeePassFile database = KeePassDatabase.getInstance(keePassFile).openDatabase(keyFile);

		// Retrieve all entries
		List<Entry> entries = database.getEntries();
		for (Entry entry : entries) {
			System.out.println("Title: " + entry.getTitle() + " Password: " + entry.getPassword());
		}

		// Retrieve all top groups
		List<Group> groups = database.getTopGroups();
		for (Group group : groups) {
			System.out.println(group.getName());
		}

		Assert.assertTrue(true);
	}
}
