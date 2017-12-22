package com.cmpe275.cusr.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trains {

	@Id
	String name;
	Character direction;
	@Column(name = "type")
	Character trainType;
//	@Transient
//	Character startStation;
//	@Transient
//	String startTime;
	@javax.persistence.Transient
	Character endStation;
	@javax.persistence.Transient
	Character startStation;
	
	String A;
	String B;
	String C;
	String D;
	String E;
	String F;
	String G;
	String H;
	String I;
	String J;
	String K;
	String L;
	String M;
	String N;
	String O;
	String P;
	String Q;
	String R;
	String S;
	String T;
	String U;
	String V;
	String W;
	String X;
	String Y;
	String Z;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getE() {
		return E;
	}

	public void setE(String e) {
		E = e;
	}

	public String getF() {
		return F;
	}

	public void setF(String f) {
		F = f;
	}

	public String getG() {
		return G;
	}

	public void setG(String g) {
		G = g;
	}

	public String getH() {
		return H;
	}

	public void setH(String h) {
		H = h;
	}

	public String getI() {
		return I;
	}

	public void setI(String i) {
		I = i;
	}

	public String getJ() {
		return J;
	}

	public void setJ(String j) {
		J = j;
	}

	public String getK() {
		return K;
	}

	public void setK(String k) {
		K = k;
	}

	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

	public String getM() {
		return M;
	}

	public void setM(String m) {
		M = m;
	}

	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	public String getO() {
		return O;
	}

	public void setO(String o) {
		O = o;
	}

	public String getP() {
		return P;
	}

	public void setP(String p) {
		P = p;
	}

	public String getQ() {
		return Q;
	}

	public void setQ(String q) {
		Q = q;
	}

	public String getR() {
		return R;
	}

	public void setR(String r) {
		R = r;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getT() {
		return T;
	}

	public void setT(String t) {
		T = t;
	}

	public String getU() {
		return U;
	}

	public void setU(String u) {
		U = u;
	}

	public String getV() {
		return V;
	}

	public void setV(String v) {
		V = v;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getZ() {
		return Z;
	}

	public void setZ(String z) {
		Z = z;
	}

	public Character getDirection() {
		return direction;
	}

	public void setDirection(Character direction) {
		this.direction = direction;
	}

	public Character getTrainType() {
		return trainType;
	}

	public void settrainType(Character trainType) {
		this.trainType = trainType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getendStation() {
		return endStation;
	}
	public void setendStation(Character endStation) {
		this.endStation = endStation;
	}
	
	public Character getstartStation() {
		return startStation;
	}
	public void setstartStation(Character startStation) {
		this.startStation = startStation;
	}


}
