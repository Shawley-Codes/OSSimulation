# OSSimulation
This is an operating system simulation

The first simulation runs two processes to simulate basic process management and scheduling. The processes are scheduled to run on the processor for a few seconds before switching to the other. A program counter is used to display and remember where the processor left off on the last execution and the state of each process is updated and displayed, as needed. Both processes have 12 lines to execute before completion.

The second simulation demonstrates interprocess communication between two processes as well as user input from the command line. A mutex is used to prevent the two processes from manipulating the shared memory (queue) at the same time. Process 1 prompts the user to input an integer and, once received, places the integer into the shared memory and unlockes the mutex. Process 2 then locks the mutex, removes the integer, and unlockes the mutex. The cycle then repeats four more times. 

The simulation connects to the internet running two tests
	One test sends a package out to "whois.internic.net" with a domain name
	Whois returns information about the domain name, in this case "google.com"
	
	A second test occurs with a different set up creating a http client 
	and recieving information about the host the client connected to, in this case "google.com"

The simulation also provides basic file management, allowing the user to create files

The simulation also demonstrates the storage controller. The storage has 1000 fixed blocks to store information to the secondary memory. The controller is able to save objects to memory, retrieved from memory and create new objects to individual memory blocks.

