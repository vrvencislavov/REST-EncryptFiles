package com.axway.hashing.project.api;

import com.axway.hashing.project.beans.DbFile;
import com.axway.hashing.project.beans.HashAlgorithm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;

@Path("files")
public class FileFinder {

    private FileManager manager = new FileManager();

    @GET
    @Path("hash")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchFile(@QueryParam("algorithm") String algorithm,
                               @QueryParam("path") String path) throws IOException, NoSuchAlgorithmException {

        File file = new File(path);

        //Use MD5 algorithm
        MessageDigest msgAlgorithm = MessageDigest.getInstance(algorithm);
        HashAlgorithm hashAlgorithm = new HashAlgorithm();
        //Get the checksum
        String checksum = hashAlgorithm.getFileChecksum(msgAlgorithm, file);
        //see checksum
        System.out.println(checksum);
        DbFile dbResults = new DbFile(path, algorithm, checksum);

        manager.addInfo(dbResults);
        return Response.ok(dbResults).build();

    }
}