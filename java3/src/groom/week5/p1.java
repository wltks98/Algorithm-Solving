package groom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][n];

		List<Integer[]> zin = new ArrayList<>();
		List<Integer[]> ant = new ArrayList<>();

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				int a=Integer.parseInt(st.nextToken());
				if(a==1){
					ant.add(new Integer[]{i,j});
				} else if(a==2){
					zin.add(new Integer[]{i,j});
				}

				arr[i][j]=a;
			}
		}
		int answer=0;

		for(Integer[] point : ant){
			for(Integer[] point2 : zin){
				if (manhattan(point,point2)<=m){
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);



	}

	static int manhattan(Integer[] a, Integer[] b){
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}
}
