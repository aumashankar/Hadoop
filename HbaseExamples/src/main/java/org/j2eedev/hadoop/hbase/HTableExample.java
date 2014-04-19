package org.j2eedev.hadoop.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

public class HTableExample {
	public static void main(String[] args) throws IOException {
		/* 
		 * Default Tables with Hbase
		 * Catalog Table 	Description
		 *	-ROOT- 			The -ROOT- table holds references to all .META. regions.
		 *	.META. 			The .META. table holds references to all User Table regions
		 */
		Configuration conf = HBaseConfiguration.create();
		HTable hTableRoot=null;
		HTable hTableMeta=null;
		try {
			hTableRoot = new HTable(conf, "-ROOT-");
			System.out.println("Table is: " + Bytes.toString(hTableRoot.getTableName()));
			
			hTableMeta = new HTable(conf, ".META.");
			System.out.println("Table is: " + Bytes.toString(hTableMeta.getTableName()));
		}finally{
			if(hTableRoot!=null)
				hTableRoot.close();
			
			if(hTableMeta!=null)
				hTableMeta.close();
		}
	}
}
