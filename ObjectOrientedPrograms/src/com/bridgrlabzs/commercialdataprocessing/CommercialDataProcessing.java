package com.bridgrlabzs.commercialdataprocessing;

import java.io.File;
import java.io.IOException;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




public class CommercialDataProcessing {

	public static void main(String[] args) throws IOException, IOException {
		CompanyShare companyshare[];
		String pathname="/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/src/com/bridgrlabzs/commercialdataprocessing/cdp.json";
        String pathname1="/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/src/com/bridgrlabzs/commercialdataprocessing/replacefile.json";
        File file = new File(pathname);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node=mapper.readTree(file);
        JsonNode node1=node.get("second");
        companyshare=mapper.readValue(node1, CompanyShare[].class);
	}

}
