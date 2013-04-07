package com.jzap.ortophonie.activity;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import com.jzap.ortophonie.R;

public class SyllabeCibleModel {
	
	public static class ImageAndText {
		private int imageId;
		private String text;

		public ImageAndText(int imageId, String text) {
			super();
			this.imageId = imageId;
			this.text = text;
		}

		public int getImageId() {
			return imageId;
		}

		public void setImageId(int imageId) {
			this.imageId = imageId;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}
	
	public static final List<SyllabeCibleModel> syllabeCibleItems;

	static {
		syllabeCibleItems = new ArrayList<SyllabeCibleModel>();
		syllabeCibleItems.add(new SyllabeCibleModel("TA", asList( //
				new ImageAndText(R.drawable.img_pomme, "pomme"), //
				new ImageAndText(R.drawable.img_maison, "maison"), //
				new ImageAndText(R.drawable.img_bateau, "bâteau")), //
				new ImageAndText(R.drawable.img_hippopotame, "hippopo*ta*me")));
		syllabeCibleItems.add(new SyllabeCibleModel("MO", asList( //
				new ImageAndText(R.drawable.img_camera, "caméra"), //
				new ImageAndText(R.drawable.img_dominos, "dominos"), //
				new ImageAndText(R.drawable.img_tableau, "tableau")), //
				new ImageAndText(R.drawable.img_locomotive, "loco*mo*tive")));
		syllabeCibleItems.add(new SyllabeCibleModel("BI", asList( //
				new ImageAndText(R.drawable.img_balancoire, "balaçoire"), //
				new ImageAndText(R.drawable.img_toboggan, "toboggan"), //
				new ImageAndText(R.drawable.img_lit, "lit")), //
				new ImageAndText(R.drawable.img_biberon, "*bi*beron")));
		syllabeCibleItems.add(new SyllabeCibleModel("LU", asList( //
				new ImageAndText(R.drawable.img_bureau, "bureau"), //
				new ImageAndText(R.drawable.img_tasse, "tasse"), //
				new ImageAndText(R.drawable.img_ballon, "ballon")), //
				new ImageAndText(R.drawable.img_luge, "*lu*ge")));
		syllabeCibleItems.add(new SyllabeCibleModel("RO", asList( //
				new ImageAndText(R.drawable.img_rideau, "rideau"), //
				new ImageAndText(R.drawable.img_nuage, "nuage"), //
				new ImageAndText(R.drawable.img_valise, "valise")), //
				new ImageAndText(R.drawable.img_robot, "*ro*bot")));
		syllabeCibleItems.add(new SyllabeCibleModel("GI", asList( //
				new ImageAndText(R.drawable.img_garage, "garage"), //
				new ImageAndText(R.drawable.img_gorille, "gorille"), //
				new ImageAndText(R.drawable.img_fille, "fille")), //
				new ImageAndText(R.drawable.img_girafe, "*gi*rafe")));
		syllabeCibleItems.add(new SyllabeCibleModel("FU", asList( //
				new ImageAndText(R.drawable.img_fil, "fil"), //
				new ImageAndText(R.drawable.img_pull, "pull"), //
				new ImageAndText(R.drawable.img_bulle, "bulle")), //
				new ImageAndText(R.drawable.img_fusee, "*fu*sée")));
		syllabeCibleItems.add(new SyllabeCibleModel("VI", asList( //
				new ImageAndText(R.drawable.img_tapis, "tapis"), //
				new ImageAndText(R.drawable.img_bijoux, "bijoux"), //
				new ImageAndText(R.drawable.img_avocat, "avocat")), //
				new ImageAndText(R.drawable.img_television, "télé*vi*sion")));
		syllabeCibleItems.add(new SyllabeCibleModel("BOU", asList( //
				new ImageAndText(R.drawable.img_poule1, "poule"), //
				new ImageAndText(R.drawable.img_douze, "douze"), //
				new ImageAndText(R.drawable.img_bonnet, "bonnet")), //
				new ImageAndText(R.drawable.img_bouteille, "*bou*teille")));
		syllabeCibleItems.add(new SyllabeCibleModel("SA", asList( //
				new ImageAndText(R.drawable.img_escalier, "escalier"), //
				new ImageAndText(R.drawable.img_cabane, "cabane"), //
				new ImageAndText(R.drawable.img_rose, "rose")), //
				new ImageAndText(R.drawable.img_savon, "*sa*von")));
		syllabeCibleItems.add(new SyllabeCibleModel("CO", asList( //
				new ImageAndText(R.drawable.img_sauterelle, "sauterelle"), //
				new ImageAndText(R.drawable.img_cafe, "café"), //
				new ImageAndText(R.drawable.img_flocon, "flocon")), //
				new ImageAndText(R.drawable.img_cochon, "*co*chon")));
		syllabeCibleItems.add(new SyllabeCibleModel("NI", asList( //
				new ImageAndText(R.drawable.img_cheminee, "cheminée"), //
				new ImageAndText(R.drawable.img_pile, "pile"), //
				new ImageAndText(R.drawable.img_bananes, "bananes")), //
				new ImageAndText(R.drawable.img_chenille, "che*ni*lle")));
		syllabeCibleItems.add(new SyllabeCibleModel("EN", asList( //
				new ImageAndText(R.drawable.img_ecureuil, "écureuil"), //
				new ImageAndText(R.drawable.img_abeille, "abeille"), //
				new ImageAndText(R.drawable.img_ane, "âne")), //
				new ImageAndText(R.drawable.img_enveloppe, "*en*veloppe")));
		syllabeCibleItems.add(new SyllabeCibleModel("POI", asList( //
				new ImageAndText(R.drawable.img_trampoline, "trampoline"), //
				new ImageAndText(R.drawable.img_framboise, "framboise"), //
				new ImageAndText(R.drawable.img_bottes, "bottes")), //
				new ImageAndText(R.drawable.img_poisson, "*poi*sson")));

	}

	private String syllabe;

	private List<ImageAndText> wrongImageIds;

	private ImageAndText rightImageId;

	public SyllabeCibleModel(String syllabe, List<ImageAndText> wrongImageIds,
			ImageAndText rightImageId) {
		super();
		this.syllabe = syllabe;
		this.wrongImageIds = wrongImageIds;
		this.rightImageId = rightImageId;
	}

	public String getSyllabe() {
		return syllabe;
	}

	public void setSyllabe(String syllabe) {
		this.syllabe = syllabe;
	}

	public List<ImageAndText> getWrongImageIds() {
		return wrongImageIds;
	}

	public void setWrongImageIds(List<ImageAndText> wrongImageIds) {
		this.wrongImageIds = wrongImageIds;
	}

	public ImageAndText getRightImageId() {
		return rightImageId;
	}

	public void setRightImageId(ImageAndText rightImageId) {
		this.rightImageId = rightImageId;
	}

	
	

}
