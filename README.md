# gRPC Android Client
Simple gRPC Android client with server-side streaming  
The client writes gRPC messages to the local database using Room and displays them in RecyclerView

# Libraries
gRPC, RxJava & RxAndroid, Room

# Before running
1. Go to [gRPC Java Server](https://github.com/coding-lamer555/GrpcJavaServer) repo, download project, build and run server
2. Go to MainActivity.java and replace ADDRESS variable value with the IPv4-address of the device on which the server was started (it must be on the same network as the device on which the client will be launched)