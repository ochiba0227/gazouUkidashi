package gazouukidashi;

import processing.core.*;

@SuppressWarnings("serial")
public class gazouukidashi extends PApplet {
	int[] x = new int[2];								//�l�p�𓮂������߂̔z��(x��
	int[] y = new int[2];								//�l�p�𓮂������߂̔z��(y��
	int xrand=(int)(random(4))+10;							//�l�p�̓����������߂�(x��
	int yrand=(int)(random(4))+10;							//�l�p�̓����������߂�(y��
	int flag = 4;										//���ˎ��̓����̃p�^�[��4��

	void hansha(){										//���ˎ��ɌĂяo�����֐�
	  xrand = (int)(random(4))+10;
	  yrand = (int)(random(4))+10;
	  x[0]=x[1];										//���ˑO�̍��W���L�����C���̔��ˎ��ɗ��p����
	  y[0]=y[1];										//���ˑO�̍��W���L�����C���̔��ˎ��ɗ��p����
	}

	void defaultimage(){								//�n�߂ɓǂݍ��܂ꂽ�摜���ēx�Ăяo���֐�
	  PImage b = loadImage("gazouukidashi/monariza.jpg");					//�p�ӂ����摜
	  image(b, 0, 160);									//�摜��`��
	}

	public void setup(){										//������
	  size(640,640);									//�E�C���h�E�T�C�Y
	  defaultimage();
	  fill(255);
	  rect(0,0,640,160);
	  fill(random(255),random(255),random(255));
	  textSize(60); 
	  text("Processing��",0,50); 									//���������摜��\������֐�
	  text("�v���O���~���O�̌��I�I",0,120); 
	  noStroke();										//�g�����ŕ`�悷��
	  fill(0,230);										//�h��Ԃ��F�̎w��
	  rect(0,160,640,480);								//�l�p�`��`��
	  frameRate(600);
	  x[1]=1;
	  y[1]=160;									//�t���[�����[�g(����͕b��60�t���[��
	}

	public void draw(){
	  if(mousePressed==false){									//���ۂɓ��삷��Ƃ���
	  if(x[1]<width&&y[1]<height&&x[1]>-20&&y[1]>130){		//�摜�̂Ȃ��Ƃ����ǂݎ��Ǝ~�܂��Ă��܂��̂Řg�O�ɏo���Ƃ��͓ǂݎ����~�߂�
	    PImage now = get(0,160,640,480);					//���݂̉�ʑS�̂��擾(��1
	    defaultimage();									//���������摜��\������֐�
	    PImage pi = get(x[1], y[1], 30, 30);			//���������摜�̈ꕔ���擾(��2
	    image(now,0,160);									//��1�Ŏ擾������ʂ�\��
	    set(x[1],y[1],pi);								//��2�Ŏ擾�����摜�̈ꕔ��\��
	  }
	  if(x[1]>=width&&y[0]>height/2){					//�ȉ��ǂɓ����������̃p�^�[��
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
	    text("Processing��",0,50); 									//���������摜��\������֐�
	    text("�v���O���~���O�̌��I�I",0,120); 
	    defaultimage();									//���������摜��\������֐�
	    noStroke();										//�g�����ŕ`�悷��
	    fill(0,230);										//�h��Ԃ��F�̎w��
	    rect(0,160,640,640);
	  }
	  if(key==ESC){
		  exit();
	  }
	}
	public void mouseDragged(){
	    PImage now = get(0,160,640,480);					//���݂̉�ʑS�̂��擾(��1
	    defaultimage();									//���������摜��\������֐�
	    PImage pi = get(mouseX, mouseY, 30, 30);			//���������摜�̈ꕔ���擾(��2
	    image(now,0,160);									//��1�Ŏ擾������ʂ�\��
	    set(mouseX,mouseY,pi);
	}
	public void mousePressed(){
	    PImage now = get(0,160,640,480);					//���݂̉�ʑS�̂��擾(��1
	    defaultimage();									//���������摜��\������֐�
	    PImage pi = get(mouseX, mouseY, 30, 30);			//���������摜�̈ꕔ���擾(��2
	    image(now,0,160);									//��1�Ŏ擾������ʂ�\��
	    set(mouseX,mouseY,pi);	
	}
  public static void main(String args[]){
	    PApplet.main(new String[] {"gazouukidashi.gazouukidashi"});
	}
}