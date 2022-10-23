package ism.inscription.entities.core;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class config {
    private static final String  file="src/main/resources/ism/inscription/parametre.json";
    public static JsonNode laodJsonFile() throws StreamReadException, DatabindException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(file);
        JsonNode jsonNode = mapper.readValue(jsonFile, JsonNode.class);
        return jsonNode;
    }
    public static int getSeqClasse() throws StreamReadException, DatabindException, IOException{
        JsonNode root= laodJsonFile();
        JsonNode sequenceNode= root.get("sequence");
        JsonNode classeNode = sequenceNode.get("classe");
        return classeNode.asInt();
    
    }
    public static int getSeqEtudiant() throws StreamReadException, DatabindException, IOException{
        JsonNode root= laodJsonFile();
        JsonNode sequenceNode= root.get("sequence");
        JsonNode etudiantNode = sequenceNode.get("etudiant");
        return etudiantNode.asInt();
    }
    public static int getSeqProfesseur() throws StreamReadException, DatabindException, IOException{
        JsonNode root= laodJsonFile();
        JsonNode sequenceNode= root.get("sequence");
        JsonNode ProfesseurNode = sequenceNode.get("professeur");
        return ProfesseurNode.asInt();
    }

}

       /*  JsonNode sequenceNode = jsonNode.get("sequence");

       

        JsonNode classeNode = sequenceNode.get("classe");
        int classeseq = classeNode.asInt();
        JsonNode professeurNode = sequenceNode.get("classe");
        int professeurseq = professeurNode.asInt();
        JsonNode etudiantNode = sequenceNode.get("classe");
        int etudiantseq = etudiantNode.asInt(); */
        

    
