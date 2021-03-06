package com.revature.ormdemo;

import java.util.List;

import com.revature.demomodels.DummyUser;
import com.revature.util.ColumnField;
import com.revature.util.Configuration;
import com.revature.util.ForeignKeyField;
import com.revature.util.MetaModel;
import com.revature.util.PrimaryKeyField;

/*
 * We'll pretend that this class is the class of some developer that pulled in our ORM as a dependency
 */
public class Driver {
	
	public static void main(String[] args) {
		
		/*
		 * We need to "load" the class of our project into the ORM
		 * We need to convert them to metamodels
		 * We also need to establish a connection to the DB by feeding our DB credentials to 
		 * the ORM
		 * 
		 * 
		 * 
		 * Hibernate reads from the hibernate.cfg.xml file but it can be done like this
		 */
		
		
		// The documentation should probably provide some insight into creating you config object
		
		Configuration cfg = new Configuration();
		
		// Step 1 is to add the annotated classes
		
		//This is where we'd add in a class to model
		cfg.addAnnotatedClass(DummyUser.class);
		
		// Step 2: Establish connection to DB uses the DB creds and go from there
		cfg.getConnection("someURL", "dbUsername", "dbPassword");
		
		// We'll iterate over each class that's added and provide some info about the class
		
		for (MetaModel<?> metaModel: cfg.getMetaModels()) {
			
			System.out.printf("Printing Metamodel for class: %s\n", metaModel.getClassName());
			// Let's get the fields from our class
			PrimaryKeyField pk = metaModel.getPrimaryKey();
			List<ColumnField> columns = metaModel.getColumns();
			List<ForeignKeyField> foreignKeyFields = metaModel.getForeignKeys();
			
			System.out.printf("\t Found a primary key field named %s, of type %s, which maps to the column with name: %s\n",
								pk.getName(), pk.getType(),pk.getColumnName());
			
			// Information about the columns
			
			for (ColumnField column: columns) {
				System.out.printf("\t Found a column field named %s, of type %s, which maps to the column with name: %s\n",
						column.getName(), column.getType(),column.getColumnName());
			}
			
			// Information about foreign keys
			for (ForeignKeyField fk: foreignKeyFields) {
				System.out.printf("\t Found a foreign column field named %s, of type %s, which maps to the column with name: %s\n",
						fk.getName(), fk.getType(), fk.getColumnName());
			}
			
			
		}
		
		
	}

}
