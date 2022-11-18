//----FCFS First Come First Serve

import java.util.Scanner;

class fcfs {
	public static void main(String args[]) {
		int burst_time[], process[], waiting_time[], tat[], i, j, n, total = 0;
		float wait_avg, TAT_avg;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of process: ");
		n = s.nextInt();
		process = new int[n];
		burst_time = new int[n];
		waiting_time = new int[n];
		tat = new int[n];
		System.out.println("\nEnter Burst time:");
		for (i = 0; i < n; i++) {
			System.out.print("\nProcess[" + (i + 1) + "]: ");
			burst_time[i] = s.nextInt();
			process[i] = i + 1; // Process Number
		}
		s.close();
		// First process has 0 waiting time
		waiting_time[0] = 0;
		// calculate waiting time
		for (i = 1; i < n; i++) {
			waiting_time[i] = 0;
			for (j = 0; j < i; j++)
				waiting_time[i] += burst_time[j];
			total += waiting_time[i];
		}
		// Calculating Average waiting time
		wait_avg = (float) total / n;
		total = 0;
		System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
		for (i = 0; i < n; i++) {
			tat[i] = burst_time[i] + waiting_time[i];
			total += tat[i];// Calculating TurnaroundTimetotal+=tat[i];
			System.out.println(
					"\n p" + process[i] + "\t\t" + burst_time[i] + "\t\t" + waiting_time[i] + "\t\t " + tat[i]);
		}
		// Calculation of Average Turnaround Time
		TAT_avg = (float) total / n;
		System.out.println("\n\nAverage Waiting Time: " + wait_avg);
		System.out.println("\nAverage Turnaround Time: " + TAT_avg);
		s.close();
	}

}








//----- Priority
import java.util.Scanner;
public class Priority {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int x,n,p[],pp[],bt[],w[],t[],awt,atat,i;
		p = new int[10];
		pp = new int[10];
		bt = new int[10];
		w = new int[10];
		t = new int[10];
		//n is number of process
		//p is process
		//pp is process priority
		//bt is process burst time
		//w is wait time
		// t is turnaround time
		//awt is average waiting time
		//atat is average turnaround time
		System.out.print("Enter the number of process : ");
		n = s.nextInt();
		System.out.print("\n\t Enter burst time : time priorities \n");
		for(i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"]:");
			bt[i] = s.nextInt();
			pp[i] = s.nextInt();
			p[i]=i+1;
		}
		//sorting on the basis of priority
		for(i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(pp[i]<pp[j])
				{
					x=pp[i];
					pp[i]=pp[j];
					pp[j]=x;
					x=bt[i];
					bt[i]=bt[j];
					bt[j]=x;
					x=p[i];
					p[i]=p[j];
					p[j]=x;
				}
			}
		}
		w[0]=0;
		awt=0;
		t[0]=bt[0];
		atat=t[0];
		for(i=1;i<n;i++)
		{
			w[i]=t[i-1];
			awt+=w[i];
			t[i]=w[i]+bt[i];
			atat+=t[i];
		}
		//Displaying the process
		System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time Priority \n");
		for(i=0;i<n;i++)
			System.out.print("\n "+p[i]+"\t\t "+bt[i]+"\t\t "+w[i]+"\t\t"+t[i]+"\t\t "+pp[i]+"\n");
		
		awt/=n;
		atat/=n;
		System.out.print("\n Average Wait Time : "+awt);
		System.out.print("\n Average Turn Around Time : "+atat);
	}
}






//-----Round Robin
import java.util.Scanner;
public class Roundfinal1 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int wtime[],btime[],rtime[],num,quantum;
		wtime = new int[10];
		btime = new int[10];
		rtime = new int[10];
		System.out.print("Enter number of processes(MAX 10): ");
		num = s.nextInt();
		System.out.print("Enter burst time");
		for(int i=0;i<num;i++) 
		{ 
			System.out.print("\nP["+(i+1)+"]: "); 
			btime[i] = s.nextInt(); 
			rtime[i] = btime[i]; 
			wtime[i]=0; 
		} 
		System.out.print("\n\nEnter quantum: "); 
		quantum = s.nextInt(); 
		int rp = num; 
		int i=0; 
		int time=0; 
		System.out.print("0"); 
		wtime[0]=0; 
		while(rp!=0) { 
			if(rtime[i]>quantum)
			{
				rtime[i]=rtime[i]-quantum;
				System.out.print(" | P["+(i+1)+"] | ");
				time+=quantum;
				System.out.print(time);
			}
			else if(rtime[i]<=quantum && rtime[i]>0)
			{
				time+=rtime[i];
				rtime[i]=rtime[i]-rtime[i];
				System.out.print(" | P["+(i+1)+"] | ");
				rp--;
				System.out.print(time);
			}
			i++;
			if(i==num)
			{
				i=0;
			}
		}
	}
}






//-----SJF Shortest Job First
import java.util.Scanner;

class SJF {
	public static void main(String args[]) {
		int burst_time[], process[], waiting_time[], tat[], i, j, n, total = 0, pos, temp;
		float wait_avg, TAT_avg;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of process: ");
		n = s.nextInt();
		process = new int[n];
		burst_time = new int[n];
		waiting_time = new int[n];
		tat = new int[n];
		System.out.println("\nEnter Burst time:");
		for (i = 0; i < n; i++) {
			System.out.print("\nProcess[" + (i + 1) + "]: ");
			burst_time[i] = s.nextInt();
			;
			process[i] = i + 1; // Process Number
		}
		// Sorting
		for (i = 0; i < n; i++) {
			pos = i;
			for (j = i + 1; j < n; j++) {
				if (burst_time[j] < burst_time[pos])
					pos = j;
			}
			temp = burst_time[i];
			burst_time[i] = burst_time[pos];
			burst_time[pos] = temp;
			temp = process[i];
			process[i] = process[pos];
			process[pos] = temp;
		}
		// First process has 0 waiting time
		waiting_time[0] = 0;
		// calculate waiting time
		for (i = 1; i < n; i++) {
			waiting_time[i] = 0;
			for (j = 0; j < i; j++)
				waiting_time[i] += burst_time[j];
			total += waiting_time[i];
		}
		// Calculating Average waiting time
		wait_avg = (float) total / n;
		total = 0;
		System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
		for (i = 0; i < n; i++) {
			tat[i] = burst_time[i] + waiting_time[i]; // Calculating Turnaround Time
			total += tat[i];
			System.out.println(
					"\n p" + process[i] + "\t\t " + burst_time[i] + "\t\t " + waiting_time[i] + "\t\t " + tat[i]);
		}
		// Calculation of Average Turnaround Time
		TAT_avg = (float) total / n;
		System.out.println("\n\nAverage Waiting Time: " + wait_avg);
		System.out.println("\nAverage Turnaround Time: " + TAT_avg);
	}

}





//------FIFO
import java.io.*;

public class FIFO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        int buffer[];
        int reference[];
        int mem_layout[][];

        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());

        System.out.println("Please enter the length of the Reference string: ");
        ref_len = Integer.parseInt(br.readLine());

        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                buffer[pointer] = reference[i];
                fault++;
                pointer++;
                if (pointer == frames)
                    pointer = 0;
            }
            for (int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }

        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                System.out.printf("%3d ", mem_layout[j][i]);
            System.out.println();
        }

        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
        System.out.println("The number of Faults: " + fault);
    }

}






//------LRU
import java.io.*;
import java.util.*;

public class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        Boolean isFull = false;
        int buffer[];
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int reference[];
        int mem_layout[][];

        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());

        System.out.println("Please enter the length of the Reference string:");
        ref_len = Integer.parseInt(br.readLine());

        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        for (int i = 0; i < ref_len; i++) {
            if (stack.contains(reference[i])) {
                stack.remove(stack.indexOf(reference[i]));
            }
            stack.add(reference[i]);
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                if (isFull) {
                    int min_loc = ref_len;
                    for (int j = 0; j < frames; j++) {
                        if (stack.contains(buffer[j])) {
                            int temp = stack.indexOf(buffer[j]);
                            if (temp < min_loc) {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                pointer++;
                if (pointer == frames) {
                    pointer = 0;
                    isFull = true;
                }
            }
            for (int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }

        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                System.out.printf("%3d ", mem_layout[j][i]);
            System.out.println();
        }

        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
        System.out.println("The number of Faults: " + fault);
    }

}





//-------Optimal Replacement
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        boolean isFull = false;
        int buffer[];
        int reference[];
        int mem_layout[][];

        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());

        System.out.println("Please enter the length of the Reference string:");
        ref_len = Integer.parseInt(br.readLine());

        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                if (isFull) {
                    int index[] = new int[frames];
                    boolean index_flag[] = new boolean[frames];
                    for (int j = i + 1; j < ref_len; j++) {
                        for (int k = 0; k < frames; k++) {
                            if ((reference[j] == buffer[k]) && (index_flag[k] == false)) {
                                index[k] = j;
                                index_flag[k] = true;
                                break;
                            }
                        }
                    }
                    int max = index[0];
                    pointer = 0;
                    if (max == 0)
                        max = 200;
                    for (int j = 0; j < frames; j++) {
                        if (index[j] == 0)
                            index[j] = 200;
                        if (index[j] > max) {
                            max = index[j];
                            pointer = j;
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                if (!isFull) {
                    pointer++;
                    if (pointer == frames) {
                        pointer = 0;
                        isFull = true;
                    }
                }
            }
            for (int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }

        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                System.out.printf("%3d ", mem_layout[j][i]);
            System.out.println();
        }

        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
        System.out.println("The number of Faults: " + fault);
    }

}
