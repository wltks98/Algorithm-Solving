package groom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p2 {

	static boolean[][] visited;
	static boolean[][] visited2;

	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};

	static int n;
	static int m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[n][m];

		visited=new boolean[n][m];
		visited2=new boolean[n][m];


		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				int a=Integer.parseInt(st.nextToken());
				arr[i][j]=a;
			}
		}

		int time=0;

		while (true){

			int island=0;

			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(!visited[i][j] && arr[i][j]==1){
						visited[i][j]=true;
						dfs(i,j);
						island++;
					}
				}
			}

			if (island >=2){
				System.out.println(time);
				return;
			}

			if(island==0){
				System.out.println(-1);
				return;
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++) {
					if (arr[i][j]==1 || visited2[i][j])
						continue;
					visited2[i][j]=true;
					for(int k=0; k<4; k++){
						int nx=i+dx[k];
						int ny=j+dy[k];

						if(nx<0 || ny <0 || nx>=n || ny>=m)
							continue;
						if(arr[nx][ny]==0)
							continue;
						arr[nx][ny]=0;
						visited2[nx][ny]=true;
					}
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++) {
					visited[i][j]=visited2[i][j]=false;
				}
			}
			time++;

		}




	}

	static void dfs(int x, int y){
		for(int i=0; i<4; i++){
			int nx=x+dx[i];
			int ny=y+dy[i];

			if(nx<0 || ny <0 || nx>=n || ny>=m)
				continue;
			if(visited[nx][ny] || arr[nx][ny]==0)
				continue;
			visited[nx][ny]=true;
			dfs(nx,ny);

		}
	}
}
