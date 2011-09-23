package gazouukidashi;

import processing.core.*;

@SuppressWarnings("serial")
public class gazouukidashi extends PApplet {
	int[] x = new int[2];								//四角を動かすための配列(x軸
	int[] y = new int[2];								//四角を動かすための配列(y軸
	int xrand=(int)(random(4))+10;							//四角の動き方を決める(x軸
	int yrand=(int)(random(4))+10;							//四角の動き方を決める(y軸
	int flag = 4;										//反射時の動きのパターン4つ

	void hansha(){										//反射時に呼び出される関数
	  xrand = (int)(random(4))+10;
	  yrand = (int)(random(4))+10;
	  x[0]=x[1];										//反射前の座標を記憶し，次の反射時に利用する
	  y[0]=y[1];										//反射前の座標を記憶し，次の反射時に利用する
	}

	void defaultimage(){								//始めに読み込まれた画像を再度呼び出す関数
	  PImage b = loadImage("gazouukidashi/monariza.jpg");					//用意した画像
	  image(b, 0, 160);									//画像を描画
	}

	public void setup(){										//下準備
	  size(640,640);									//ウインドウサイズ
	  defaultimage();
	  fill(255);
	  rect(0,0,640,160);
	  fill(random(255),random(255),random(255));
	  textSize(60); 
	  text("Processingで",0,50); 									//準備した画像を表示する関数
	  text("プログラミング体験！！",0,120); 
	  noStroke();										//枠無しで描画する
	  fill(0,230);										//塗りつぶす色の指定
	  rect(0,160,640,480);								//四角形を描画
	  frameRate(600);
	  x[1]=1;
	  y[1]=160;									//フレームレート(今回は秒間60フレーム
	}

	public void draw(){
	  if(mousePressed==false){									//実際に動作するところ
	  if(x[1]<width&&y[1]<height&&x[1]>-20&&y[1]>130){		//画像のないところを読み取ると止まってしまうので枠外に出たときは読み取りを止める
	    PImage now = get(0,160,640,480);					//現在の画面全体を取得(※1
	    defaultimage();									//準備した画像を表示する関数
	    PImage pi = get(x[1], y[1], 30, 30);			//準備した画像の一部を取得(※2
	    image(now,0,160);									//※1で取得した画面を表示
	    set(x[1],y[1],pi);								//※2で取得した画像の一部を表示
	  }
	  if(x[1]>=width&&y[0]>height/2){					//以下壁に当たった時のパターン
	    flag=1;
	    hansha();
	  }
	  else if(x[1]>=width&&y[0]<=height/2){
	    flag=2;
	    hansha();
	  }
	  else if(x[1]<=-20&&y[0]>height/2){
	    flag=3;
	    hansha();
	  }
	  else if(x[1]<=-20&&y[0]<=height/2){
	    flag=4;
	    hansha();
	  }
	  else if(x[0]>=width/2&&y[1]>=height){
	    flag=1;
	    hansha();
	  }
	  else if(x[0]>=width/2&&y[1]<=130){
	    flag=2;
	    hansha();
	  }
	  else if(x[0]<width/2&&y[1]>=height){
	    flag=3;
	    hansha();
	  }
	  else if(x[0]<width/2&&y[1]<=130){
	    flag=4;
	    hansha();
	  }
	 
	  if(flag==1){
	    x[1]=x[1]-xrand;
	    y[1]=y[1]-yrand;
	  }
	  else if(flag==2){
	    x[1]=x[1]-xrand;
	    y[1]=y[1]+yrand;
	  }
	  else if(flag==3){
	    x[1]=x[1]+xrand;
	    y[1]=y[1]-yrand;
	  }
	  else if(flag==4){
	    x[1]=x[1]+xrand;
	    y[1]=y[1]+yrand;
	  }
	}
	}
	public void keyPressed(){
	  if(key=='c'){ 
	    fill(255);
	    rect(0,0,640,160);
	    fill(random(255),random(255),random(255));
	    textSize(60); 
	    text("Processingで",0,50); 									//準備した画像を表示する関数
	    text("プログラミング体験！！",0,120); 
	    defaultimage();									//準備した画像を表示する関数
	    noStroke();										//枠無しで描画する
	    fill(0,230);										//塗りつぶす色の指定
	    rect(0,160,640,640);
	  }
	  if(key==ESC){
		  exit();
	  }
	}
	public void mouseDragged(){
	    PImage now = get(0,160,640,480);					//現在の画面全体を取得(※1
	    defaultimage();									//準備した画像を表示する関数
	    PImage pi = get(mouseX, mouseY, 30, 30);			//準備した画像の一部を取得(※2
	    image(now,0,160);									//※1で取得した画面を表示
	    set(mouseX,mouseY,pi);
	}
	public void mousePressed(){
	    PImage now = get(0,160,640,480);					//現在の画面全体を取得(※1
	    defaultimage();									//準備した画像を表示する関数
	    PImage pi = get(mouseX, mouseY, 30, 30);			//準備した画像の一部を取得(※2
	    image(now,0,160);									//※1で取得した画面を表示
	    set(mouseX,mouseY,pi);	
	}
  public static void main(String args[]){
	    PApplet.main(new String[] {"gazouukidashi.gazouukidashi"});
	}
}