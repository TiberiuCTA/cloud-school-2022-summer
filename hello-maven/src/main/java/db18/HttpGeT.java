package db18;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HttpGeT {
    public static void main(String[] args) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        /*HttpGet httpget = new HttpGet(" ");

        System.out.println("Request Type: "+httpget.getMethod());

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());*/

        List<User> list = List.of(new User("cmz1", "cmz", "cmz"),
                new User("cmz2", "cmz", "cmz"),
                new User("cmzaa3", "cmz", "cmz"),
                new User("cmzaa4", "cmz", "cmz"),
                new User("cmz5", "cmz", "cmz"));


        CompletableFuture<List<User>> getUser = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                return list;
            } catch (InterruptedException exception) {
                throw new RuntimeException();
            }
        });

        CompletableFuture<List<String>> getAllNames = getUser.thenApply(users -> {
            //users.stream().map(User::getName);
            List<String> emptyList = new ArrayList<>();
            for (User u : users)
                emptyList.add(u.getName());

            return emptyList;
        });

        CompletableFuture<List<String>> getAllNamesLonger = getAllNames.thenApply(names -> {
            List<String> nameList = new ArrayList<>();
            names.stream().filter(name -> name.length() > 5).forEach(nameList::add);

            return nameList;
        });


        try {
            System.out.println(getUser.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(getAllNames.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(getAllNamesLonger.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
