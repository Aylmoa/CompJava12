package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.nio.file.*;
import java.util.Map;

public class AdressBook {
    HashMap<String, String> ola= new HashMap<>();
    Path origi=null;
    public AdressBook() throws IOException {load();}

    public void load() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("src%scom%scompany%sContact", separator, separator, separator);
        Path orig = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(orig, Charset.defaultCharset()); ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] resul=line.split("[,]",0);
                ola.put(resul[0],resul[1]);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        origi=orig;
    }

    public void Save(){
        try (BufferedWriter writer = Files.newBufferedWriter(origi, Charset.defaultCharset())) {
            for (Map.Entry<String, String> entry : ola.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                writer.write(entry.getKey()+","+entry.getValue()+ System.lineSeparator());
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);}
    }

    public void list() throws IOException {
        load();
        System.out.println("Contactos");
        for (String m: ola.keySet()) {
            System.out.println(m+" : "+ola.get(m));
        }
    }

    public void create(String num, String nombre){
        num="{"+num+"}";
        nombre="{"+nombre+"}";
        ola.put(num,nombre);
        Save();
    }

    public void delete(String num){
        num="{"+num+"}";
        try {
            ola.remove(num); Save();
        } catch (Exception e) {
            e.printStackTrace();}
    }
}
