import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LoadBalancer {
    public static class Server implements Comparable<Server> {
        private int endTime;
        private int id;

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Server(int id, int endTime) {
            this.endTime = endTime;
            this.id = id;
        }

        @Override
        public int compareTo(Server otherServer) {
            return this.endTime - otherServer.endTime;
        }
    }

    public static class Request {
        private int processTime;
        private int startTime;

        public Request(int processTime, int startTime) {
            this.processTime = processTime;
            this.startTime = startTime;
        }
    }

    public static void loadBalancing(int serverSize, int[] arrivalTime, int[] processTime) {
        PriorityQueue<Server> availableServers = new PriorityQueue<>();
        int[] orderOfServerCalls = new int[arrivalTime.length];
        for (int i = 0; i < serverSize; i++) {
            availableServers.add(new Server(i, 0));
        }
        for (int i = 0; i < arrivalTime.length; i++) {
            boolean dropFlag = false;
//            Request request = new Request(processTime[i], arrivalTime[i]);
            int requestEndTime = arrivalTime[i] + processTime[i];
            for (int j = 0; j < serverSize; j++) {
                if (availableServers.size() != 0) {
                    Server server = availableServers.poll();
                    if (server.endTime <= arrivalTime[i]) {
                        orderOfServerCalls[i] = server.getId();
                        server.setEndTime(requestEndTime);
                        availableServers.add(server);
                        System.out.println("Request " + i + " processed by Server " + server.id + " from "
                                + arrivalTime[i] + " to " + server.endTime);
                        dropFlag = true;
                        break;
                    } else{
                        availableServers.add(server);
                    }
                }
            }
            if (!dropFlag) {
                orderOfServerCalls[i] = -1;
                System.out.println("Request " + i + " is dropped.");
            }
        }
    }

    public static void main(String[] args) {
        int[] arrivalTime = {1, 2, 3, 4, 5,4};
        int[] processTime = {2, 2, 1, 3, 4,5};
        int M = 2;

        // Function Call
        loadBalancing(M, arrivalTime, processTime);
    }
}
