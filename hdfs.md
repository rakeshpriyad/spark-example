
$ hadoop namenode -format
After formatting the HDFS, start the distributed file system. The following command will start the namenode as well as the data nodes as cluster.

$ start-dfs.sh
Listing Files in HDFS
After loading the information in the server, we can find the list of files in a directory, status of a file, using ‘ls’. Given below is the syntax of ls that you can pass to a directory or a filename as an argument.

$ $HADOOP_HOME/bin/hadoop fs -ls <args>
Inserting Data into HDFS
Assume we have data in the file called file.txt in the local system which is ought to be saved in the hdfs file system. Follow the steps given below to insert the required file in the Hadoop file system.

Step 1
You have to create an input directory.

$ $HADOOP_HOME/bin/hadoop fs -mkdir /user/input
Step 2
Transfer and store a data file from local systems to the Hadoop file system using the put command.

$ $HADOOP_HOME/bin/hadoop fs -put /home/rakesh/input.txt /user/input
Step 3
You can verify the file using ls command.

$ $HADOOP_HOME/bin/hadoop fs -ls /user/input
Retrieving Data from HDFS
Assume we have a file in HDFS called outfile. Given below is a simple demonstration for retrieving the required file from the Hadoop file system.

Step 1
Initially, view the data from HDFS using cat command.

$ $HADOOP_HOME/bin/hadoop fs -cat /user/input/input.txt
Step 2
Get the file from HDFS to the local file system using get command.

$ $HADOOP_HOME/bin/hadoop fs -get /user/input/ /home/rakesh/hadoop_tp/
Shutting Down the HDFS
You can shut down the HDFS by using the following command.

$ stop-dfs.sh
