package com.tlbb;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test_GM extends JFrame implements ActionListener {
	Container cont1 = null;

	private static java.sql.Connection con = null; // ����Connection ����
	private static java.sql.Statement sta = null; // ���� Statement ����
	private static ResultSet rs = null; // ����ResultSet ����

	JTextField ip_text, port_text, user_text, dbname_text; // ����JTextField ����
	JPasswordField passwd_text;
	JLabel ip_label, port_label, user_label, passwd_label, dbname_label; // ����JLabel����
	JButton connect_button, by_account_button, by_character_button,
			search_button1, info_button, pate_button, xinfa_button,
			sure_button, search_button2, search_button3; // �������Ӱ�ť
	static String db_info = null; // ���ڴ������ݿ��Ƿ����ӳɹ�
	JLabel info1, info2, info3, info4, auther; // �����ʾ
	static String name_arr[] = new String[3];
	// Vector<String> name_list = new Vector<String>(); // ��������
	JTextArea account_area; // �������ѯ�˺���ʾ��
	JLabel account_label, character_lable; // ����˺� ��ǩ
	JTextField account_text, character_text; // ���� �˺� �����
	static JComboBox character_box; // ���˺Ų�ѯ��������ʾ��
	static String character_name = null; // ��������
	static String character_account = null; // �����˺�
	static String account, character, search_info, sure_info; // account�����˺�character��������search_info
																// �ж��Ƿ��ѯ�ɹ�sure_info�ж��Ƿ��޸ĳɹ�

	// �������� label ����
	JLabel name, liliang, money, dengji, lingqi, shane, jingli, tili, shaqi,
			jinglishangxian, dingli, jingyan, huoli, shenfa, qianneng, yuanbao,
			menpai, zengdian, zuobiao_x, zuobiao_z, renwuID, zhanghao, xingbie;
	// �������� JTextArea ����
	JTextArea name_t, liliang_t, money_t, dengji_t, lingqi_t, shane_t,
			jingli_t, tili_t, shaqi_t, jinglishangxian_t, dingli_t, jingyan_t,
			huoli_t, shenfa_t, qianneng_t, yuanbao_t, menpai_t, zengdian_t,
			zuobiao_x_t, zuobiao_z_t, renwuID_t, zhanghao_t, xingbie_t;

	public Test_GM() {
		JFrame frame = new JFrame();
		// super("The truth"); // ���� JFrame ����
		setSize(530, 600); // ���ô��ڴ�С
		setTitle("             ��һ�ֵ�������ȴ�ĳ��      ");
		setVisible(true); // ���ô��ڿɼ���
		setResizable(false); // ���ô��ڴ�СΪ���ɸı�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.setLayout(null);
		cont1 = this.getContentPane();
		cont1.setLayout(null);

		// ***************** ������ һ ���ֶ��� ************************
		info1 = new JLabel("���ݿ�����");
		ip_text = new JTextField();
		port_text = new JTextField();
		user_text = new JTextField();
		passwd_text = new JPasswordField();
		dbname_text = new JTextField();

		ip_label = new JLabel("I P�� ַ");
		port_label = new JLabel("  ��    ��  ");
		user_label = new JLabel("�û���");
		passwd_label = new JLabel("��     ��");
		dbname_label = new JLabel("���ݿ���");

		info4 = new JLabel("������Ϣ��ѯ���");
		info_button = new JButton("��ɫ��Ϣ");
		pate_button = new JButton("������Ϣ");
		auther = new JLabel("---The Truth");
		xinfa_button = new JButton("�ķ�����");

		connect_button = new JButton("����"); // ����JButton

		account_label = new JLabel("��   �� ");
		character_lable = new JLabel("��  ��");
		by_account_button = new JButton("���˺�");
		by_character_button = new JButton("������");

		// ******************* ������ �� ���ֶ��� ***********************
		info2 = new JLabel("��Ϣ��ѯ");
		info3 = new JLabel("@game.sohu.com");
		search_button1 = new JButton("�� ѯ1");
		account_text = new JTextField();
		character_text = new JTextField();
		account_area = new JTextArea();
		character_box = new JComboBox();
		search_button2 = new JButton("�� ѯ2");
		search_button3 = new JButton("�� ѯ3");

		// ******************* ������ �� ���ֶ��� ***********************
		name = new JLabel("�� ɫ ��");
		liliang = new JLabel("�� �� ֵ");
		money = new JLabel("�� Ϸ ��");
		dengji = new JLabel("����ȼ�");
		lingqi = new JLabel("�� �� ֵ");
		shane = new JLabel("�� �� ֵ");
		jingli = new JLabel("�� �� ֵ");
		tili = new JLabel("�� �� ֵ");
		shaqi = new JLabel("ɱ �� ֵ");
		// jinglishangxian = new JLabel("��������");
		dingli = new JLabel("�� �� ֵ");
		jingyan = new JLabel("�� �� ֵ");
		huoli = new JLabel("�� �� ֵ");
		shenfa = new JLabel("�� �� ֵ");
		qianneng = new JLabel("Ǳ �� ֵ");
		yuanbao = new JLabel("Ԫ      ��");
		menpai = new JLabel("���ɹ���");
		zengdian = new JLabel("��      ��");
		zuobiao_x = new JLabel("�� ��   X");
		zuobiao_z = new JLabel("�� ��   Z");
		renwuID = new JLabel("�� �� ID");
		zhanghao = new JLabel("��  ��");
		xingbie = new JLabel("��      ��");

		name_t = new JTextArea();
		liliang_t = new JTextArea();
		money_t = new JTextArea();
		dengji_t = new JTextArea();
		lingqi_t = new JTextArea();
		shane_t = new JTextArea();
		jingli_t = new JTextArea();
		tili_t = new JTextArea();
		shaqi_t = new JTextArea();
		dingli_t = new JTextArea();
		jingyan_t = new JTextArea();
		huoli_t = new JTextArea();
		shenfa_t = new JTextArea();
		qianneng_t = new JTextArea();
		yuanbao_t = new JTextArea();
		menpai_t = new JTextArea();
		zengdian_t = new JTextArea();
		zuobiao_x_t = new JTextArea();
		zuobiao_z_t = new JTextArea();
		renwuID_t = new JTextArea();
		zhanghao_t = new JTextArea();
		xingbie_t = new JTextArea();

		sure_button = new JButton("ȷ���޸�");

		// ******************** ��һ���ֲ��� ****************************
		cont1.add(info1);
		info1.setBounds(200, 8, 80, 30);

		cont1.add(ip_label);
		ip_label.setBounds(15, 40, 50, 30);
		cont1.add(ip_text);
		ip_text.setBounds(70, 45, 100, 22);

		cont1.add(port_label);
		port_label.setBounds(180, 40, 50, 30);
		cont1.add(port_text);
		port_text.setBounds(240, 45, 100, 22);

		cont1.add(user_label);
		user_label.setBounds(350, 40, 50, 30);
		cont1.add(user_text);
		user_text.setBounds(400, 45, 100, 22);

		cont1.add(passwd_label);
		passwd_label.setBounds(15, 70, 50, 30);
		cont1.add(passwd_text);
		passwd_text.setBounds(70, 75, 100, 22);

		cont1.add(dbname_label);
		dbname_label.setBounds(180, 65, 70, 40);
		cont1.add(dbname_text);
		dbname_text.setBounds(240, 75, 100, 22);

		cont1.add(connect_button);
		connect_button.setBounds(360, 75, 70, 28);
		connect_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�������Ϣ
				String ip_info = ip_text.getText();
				String port_info = port_text.getText();
				String user_info = user_text.getText();
				String dbname_info = dbname_text.getText();
				String passwd_info = new String(passwd_text.getPassword());
				// String str_info = info;
				// connectMySQL(ip_info, port_info, user_info, passwd_info,
				// dbname_info);

				connectMySQL("localhost", "3306", "root", "root", "db");

				JOptionPane.showMessageDialog(null, db_info, "�û�������ʾ	",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// *********************** �ڶ����ֲ��� ******************************
		cont1.add(info2);
		info2.setBounds(212, 110, 80, 30);
		// cont1.add(auther);
		// auther.setBackground(Color.red);
		// auther.setBounds(450, 550, 80, 30);

		cont1.add(by_account_button);
		by_account_button.setBounds(20, 145, 80, 20);
		by_account_button.addActionListener(new ActionListener() { // ���˺Ų�ѯ��ť

					@Override
					public void actionPerformed(ActionEvent e) {
						// ��� �˺��� �ϴ� ��ѯ ���
						if (account_text.getText() != null) {
							account_text.setText(null);
						}
						// ��� ������ �ϴβ�ѯ���
						// if (!character_box.getSelectedItem().equals(null)) {
						character_box.setSelectedItem(null);
						// }
						// ɾ�� �������ѯ ���
						cont1.remove(character_lable);
						cont1.remove(character_text);
						cont1.remove(search_button3);
						cont1.remove(account_label);
						cont1.remove(account_area);

						// ɾ�� Ĭ������ �������
						cont1.remove(account_label);
						cont1.remove(account_text);
						cont1.remove(info3);
						cont1.remove(search_button1);
						cont1.remove(character_lable);
						cont1.remove(character_box);
						// ɾ�� ���� ��ť
						cont1.remove(search_button2);
						// ˢ�� cont1
						cont1.repaint();
						// ��� �� ���
						cont1.add(account_label);
						account_label.setBounds(15, 180, 80, 30);
						cont1.add(account_text);
						account_text.setBounds(60, 185, 90, 22);
						cont1.add(info3);
						info3.setBounds(155, 185, 150, 22);
						cont1.add(search_button2);
						search_button2.setBounds(265, 183, 70, 28);

						// ѡ���˺Ų�ѯ�� ��ѯ��ť
						search_button2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {

								if (character_box.getEditor() != null) {// �ж��������Ƿ�Ϊ�գ�����Ϊ�գ�����ϴ�����
									character_box.removeItem(character_name);
								}
								// ��������~~~~~
								account = account_text.getText()
										+ "@game.sohu.com"; // ��ȡ����������˺�
								Search_by_Acc(account); // ����info_Seacrch()����
								// *********************************
//								for (int i = 0; i < name_arr.length; i++) {
//									if (name_arr[i] != null) {
//										String str_name;
//										try {
//											str_name = new String(
//													character_name
//															.getBytes("latin1"),
//													"GBK");
//											character_box.addItem(name_arr[i]);
//										} catch (UnsupportedEncodingException e) {
//											e.printStackTrace();
//										}
//									}
//								}

								// S************************************

								if (character_name != null) { // ��character_name
																// ��= null
																// ʱ�Ž�ֵ��ӵ�character_box�У��������
									// �ַ��� ת��
									String str_name;
									try {
										str_name = new String(character_name
												.getBytes("latin1"), "GBK");
										character_box.addItem(str_name);
									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									}
								}
								// *************** ������Ϣ��ѯ��� ���� ����*************
								name_t.setText(Name_Search(account));
								liliang_t.setText(Lil_Search(account));
								money_t.setText(Money_Search(account));
								dengji_t.setText(Ch_level_Search(account));
								lingqi_t.setText(Lingq_Search(account));
								shane_t.setText(Shane_Search(account));
								jingli_t.setText(Jingl_Search(account));
								tili_t.setText(Til_Search(account));
								shaqi_t.setText(Shane_Search(account));
								huoli_t.setText(Huol_Search(account));
								dingli_t.setText(Dingl_Search(account));
								jingyan_t.setText(Jingy_Search(account));
								qianneng_t.setText(Qiann_Search(account));
								shenfa_t.setText(Shenf_Search(account));
								yuanbao_t.setText(Yuanb_Search(account));
								menpai_t.setText(Menp_Search(account));
								xingbie_t.setText(Xingb_Search(account));
								zengdian_t.setText(Zengd_Search(account));
								zuobiao_x_t.setText(Zuob_X_Search(account));
								zuobiao_z_t.setText(Zuob_Z_Search(account));
								renwuID_t.setText(Renw_ID_Search(account));

								JOptionPane.showMessageDialog(null,
										search_info, "�û���ѯ��ʾ	2",
										JOptionPane.INFORMATION_MESSAGE);
							}
						});
						cont1.add(character_lable);
						character_lable.setBounds(350, 180, 80, 30);
						cont1.add(character_box);
						character_box.setBounds(390, 185, 105, 22);

						cont1.validate(); // ȷ���޸�
					}
				});

		cont1.add(by_character_button);
		by_character_button.setBounds(99, 145, 80, 20);
		by_character_button.addActionListener(new ActionListener() { // �������ѯ

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// ��� ������ �ϴβ�ѯ ���
						if (character_text.getText() != null) {
							character_text.setText(null);
						}
						// ��� �˺����ϴβ�ѯ���
						if (account_area.getText() != null) {
							account_area.setText(null);
						}
						// ɾ�����еĶ��� (�ж��Ƿ��ж���)
						cont1.remove(account_label);
						cont1.remove(account_text);
						cont1.remove(info3);
						cont1.remove(search_button1);
						cont1.remove(search_button2);
						cont1.remove(search_button3);
						cont1.remove(character_lable);
						cont1.remove(character_box);
						// ˢ�� cont1
						cont1.repaint();
						// ���²��������ѯ��ʽ,��������
						cont1.add(character_lable);
						character_lable.setBounds(15, 180, 80, 30);
						cont1.add(character_text);
						character_text.setBounds(60, 185, 130, 22);
						cont1.add(account_label);
						account_label.setBounds(330, 181, 80, 30);
						cont1.add(account_area);
						account_area.setBounds(375, 185, 125, 22);

						cont1.add(search_button3);
						search_button3.setBounds(220, 183, 90, 28);
						// ѡ�������ѯ�� ��ѯ��ť 3
						search_button3.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if (account_area.getText() != null) {// �ж��˺����Ƿ�Ϊ�գ�����Ϊ�գ�����ϴ�����
									account_area.remove(account_area);
								}
								character = null;
								character = character_text.getText();// ��ȡ�������������
								Search_by_Char(character); // ����Search_by_Char()����
								if (character_account != null) { // ��character_account��=
																	// null
																	// ʱ�Ž�ֵ��ӵ�character_text�У��������
									// ȥ���˺ź�׺ʵ��
									int end = 0;
									for (int i = 0; i < character_account
											.length(); i++) {
										char ch = character_account.charAt(i);
										if (ch != '@') {
											end++;
											continue;
										}
										if (ch == '@') {
											break;
										}
									}
									account_area.setText(character_account
											.substring(0, end));// ��ȡ�˺Ų���
									// ****************** ���� ��ѯ��� ���� ����
									// ********
									name_t.setText(Name_Search(character_account));
									liliang_t
											.setText(Lil_Search(character_account));
									money_t.setText(Money_Search(character_account));
									dengji_t.setText(Ch_level_Search(character_account));
									lingqi_t.setText(Lingq_Search(character_account));
									shane_t.setText(Shane_Search(character_account));
									jingli_t.setText(Jingl_Search(character_account));
									tili_t.setText(Til_Search(character_account));
									shaqi_t.setText(Shane_Search(character_account));
									huoli_t.setText(Huol_Search(character_account));
									dingli_t.setText(Dingl_Search(character_account));
									jingyan_t
											.setText(Jingy_Search(character_account));
									qianneng_t
											.setText(Qiann_Search(character_account));
									shenfa_t.setText(Shenf_Search(character_account));
									yuanbao_t
											.setText(Yuanb_Search(character_account));
									menpai_t.setText(Menp_Search(character_account));
									xingbie_t
											.setText(Xingb_Search(character_account));
									zengdian_t
											.setText(Zengd_Search(character_account));
									zuobiao_x_t
											.setText(Zuob_X_Search(character_account));
									zuobiao_z_t
											.setText(Zuob_Z_Search(character_account));
									renwuID_t
											.setText(Renw_ID_Search(character_account));

								}

								JOptionPane.showMessageDialog(null,
										search_info, "�û���ѯ��ʾ	3",
										JOptionPane.INFORMATION_MESSAGE);
							}
						});

						cont1.validate(); // ȷ���޸�
					}
				});

		cont1.add(account_label);
		account_label.setBounds(15, 180, 80, 30);
		cont1.add(account_text);
		account_text.setBounds(60, 185, 90, 22);

		cont1.add(info3);
		info3.setBounds(155, 185, 150, 22);

		cont1.add(search_button1);
		search_button1.setBounds(265, 183, 70, 28);
		search_button1.addActionListener(new ActionListener() { // ��ѯ��ť

					@Override
					public void actionPerformed(ActionEvent arg0) {

						if (character_box.getEditor() != null) {// �ж��������Ƿ�Ϊ�գ�����Ϊ�գ�����ϴ�����
							character_box.removeItem(character_name);
						}
						account = account_text.getText() + "@game.sohu.com"; // ��ȡ����������˺�
						Search_by_Acc(account); // ����info_Seacrch()����

						// ��character_name !=nullʱ�Ž�ֵ��ӵ�character_box��
						if (character_name != null) {
							// �ַ���ת��
							String str_name;
							try {
								str_name = new String(character_name
										.getBytes("latin1"), "GBK");
								character_box.addItem(str_name);

							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}

							character_box.addItem(character_name);
						}

						// *************************************
						// ��� �������� ��Ϣ ���� ����
						name_t.setText(Name_Search(account));
						liliang_t.setText(Lil_Search(account));
						money_t.setText(Money_Search(account));
						dengji_t.setText(Ch_level_Search(account));
						lingqi_t.setText(Lingq_Search(account));
						shane_t.setText(Shane_Search(account));
						jingli_t.setText(Jingl_Search(account));
						tili_t.setText(Til_Search(account));
						shaqi_t.setText(Shane_Search(account));
						huoli_t.setText(Huol_Search(account));
						dingli_t.setText(Dingl_Search(account));
						jingyan_t.setText(Jingy_Search(account));
						qianneng_t.setText(Qiann_Search(account));
						shenfa_t.setText(Shenf_Search(account));
						yuanbao_t.setText(Yuanb_Search(account));
						menpai_t.setText(Menp_Search(account));
						xingbie_t.setText(Xingb_Search(account));
						zengdian_t.setText(Zengd_Search(account));
						zuobiao_x_t.setText(Zuob_X_Search(account));
						zuobiao_z_t.setText(Zuob_Z_Search(account));
						renwuID_t.setText(Renw_ID_Search(account));

						JOptionPane.showMessageDialog(null, search_info,
								"�û���ѯ��ʾ	1", JOptionPane.INFORMATION_MESSAGE);
					}
				});

		cont1.add(character_lable);
		character_lable.setBounds(350, 180, 80, 30);
		cont1.add(character_box);
		character_box.setBounds(390, 185, 105, 22);
		cont1.validate();

		// ************************ �������ֲ��� ***************************
		cont1.add(info4);
		info4.setBounds(180, 220, 111, 30);

		cont1.add(info_button);
		info_button.setBounds(20, 265, 90, 20);

		cont1.add(pate_button);
		pate_button.setBounds(110, 265, 90, 20);

		cont1.add(xinfa_button);
		xinfa_button.setBounds(200, 265, 90, 20);

		cont1.add(name);
		name.setBounds(20, 295, 50, 30);
		cont1.add(name_t);
		name_t.setBounds(80, 300, 90, 22);

		cont1.add(liliang);
		liliang.setBounds(180, 295, 50, 30);
		cont1.add(liliang_t);
		liliang_t.setBounds(240, 300, 90, 22);

		cont1.add(money);
		money.setBounds(345, 295, 50, 30);
		cont1.add(money_t);
		money_t.setBounds(400, 300, 90, 22);

		cont1.add(dengji);
		dengji.setBounds(20, 325, 70, 30);
		cont1.add(dengji_t);
		dengji_t.setBounds(80, 330, 90, 22);

		cont1.add(lingqi);
		lingqi.setBounds(180, 325, 50, 30);
		cont1.add(lingqi_t);
		lingqi_t.setBounds(240, 330, 90, 22);

		cont1.add(shane);
		shane.setBounds(345, 325, 50, 30);
		cont1.add(shane_t);
		shane_t.setBounds(400, 330, 90, 22);

		cont1.add(jingli);
		jingli.setBounds(20, 355, 70, 30);
		cont1.add(jingli_t);
		jingli_t.setBounds(80, 360, 90, 22);

		cont1.add(tili);
		tili.setBounds(180, 355, 50, 30);
		cont1.add(tili_t);
		tili_t.setBounds(240, 360, 90, 22);

		cont1.add(shaqi);
		shaqi.setBounds(345, 355, 50, 30);
		cont1.add(shaqi_t);
		shaqi_t.setBounds(400, 360, 90, 22);

		cont1.add(huoli);
		huoli.setBounds(20, 385, 70, 30);
		cont1.add(huoli_t);
		huoli_t.setBounds(80, 390, 90, 22);

		cont1.add(dingli);
		dingli.setBounds(180, 385, 50, 30);
		cont1.add(dingli_t);
		dingli_t.setBounds(240, 390, 90, 22);

		cont1.add(jingyan);
		jingyan.setBounds(345, 385, 50, 30);
		cont1.add(jingyan_t);
		jingyan_t.setBounds(400, 390, 90, 22);

		cont1.add(qianneng);
		qianneng.setBounds(20, 415, 70, 30);
		cont1.add(qianneng_t);
		qianneng_t.setBounds(80, 420, 90, 22);

		cont1.add(shenfa);
		shenfa.setBounds(180, 415, 50, 30);
		cont1.add(shenfa_t);
		shenfa_t.setBounds(240, 420, 90, 22);

		cont1.add(yuanbao);
		yuanbao.setBounds(345, 415, 50, 30);
		cont1.add(yuanbao_t);
		yuanbao_t.setBounds(400, 420, 90, 22);

		cont1.add(menpai);
		menpai.setBounds(20, 445, 70, 30);
		cont1.add(menpai_t);
		menpai_t.setBounds(80, 450, 90, 22);

		cont1.add(xingbie);
		xingbie.setBounds(180, 445, 50, 30);
		cont1.add(xingbie_t);
		xingbie_t.setBounds(240, 450, 90, 22);

		cont1.add(zengdian);
		zengdian.setBounds(345, 445, 50, 30);
		cont1.add(zengdian_t);
		zengdian_t.setBounds(400, 450, 90, 22);

		cont1.add(zuobiao_x);
		zuobiao_x.setBounds(20, 475, 70, 30);
		cont1.add(zuobiao_x_t);
		zuobiao_x_t.setBounds(80, 480, 90, 22);

		cont1.add(zuobiao_z);
		zuobiao_z.setBounds(180, 475, 50, 30);
		cont1.add(zuobiao_z_t);
		zuobiao_z_t.setBounds(240, 480, 90, 22);

		cont1.add(renwuID);
		renwuID.setBounds(345, 475, 50, 30);
		cont1.add(renwuID_t);
		renwuID_t.setBounds(400, 480, 90, 22);

		cont1.add(sure_button);
		sure_button.setBounds(200, 520, 100, 30);
		sure_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name_info = name_t.getText();
				String liliang_info = liliang_t.getText();
				String money_info = money_t.getText();
				String dengji_info = dengji_t.getText();
				String lingqi_info = lingqi_t.getText();
				String shane_info = shane_t.getText();
				String jingli_info = jingli_t.getText();
				String tili_info = tili_t.getText();
				String shaqi_info = shaqi_t.getText();
				String huoli_info = huoli_t.getText();
				String dingli_info = dingli_t.getText();
				String jingyan_info = jingyan_t.getText();
				String qianneng_info = qianneng_t.getText();
				String shenfa_info = shenfa_t.getText();
				String yuanbao_info = yuanbao_t.getText();
				String menpai_info = menpai_t.getText();
				String xingbie_info = xingbie_t.getText();
				String zengdian_info = zengdian_t.getText();
				String zuobiao_x_info = zuobiao_x_t.getText();
				String zuobiao_z_info = zuobiao_z_t.getText();
				String renwuID_info = renwuID_t.getText();
				String account_info = account_area.getText() + "@game.sohu.com";

				Sure_Change(name_info, liliang_info, money_info, dengji_info,
						lingqi_info, shane_info, jingli_info, tili_info,
						shaqi_info, huoli_info, dingli_info, jingyan_info,
						qianneng_info, shenfa_info, yuanbao_info, menpai_info,
						xingbie_info, zengdian_info, zuobiao_x_info,
						zuobiao_z_info, renwuID_info, account_info);

				JOptionPane.showMessageDialog(null, sure_info, "ȷ���޸���ʾ	",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

	// *************************************************************
	// ************************** ���� ���� ***********************
	// ���ݿ����Ӻ���
	public static void connectMySQL(String ip, String port, String user,
			String passwd, String dbname) {
		String str = null; // ������ݿ��������
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ��������
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + ip + ":"
						+ port + "/" + dbname, user, passwd); // ���ݿ�����
				str = "���ݿ����ӳɹ���";
				sta = con.createStatement();
			} catch (SQLException e) {
				str = "���ݿ�����ʧ�ܣ������¼��Ϣ�������ӣ�";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		db_info = str; // �����ݿ�����������ݸ�db_info
	}

	// ���˺Ų�ѯ����
	public static void Search_by_Acc(String str) {
	//	String name_arr1[] = new String[3];
		try {
			if (sta != null) {
				rs = sta.executeQuery("SELECT accname from t_char"); // ��ѯ���ݿ��е��˺�
				while (rs.next()) {
					str = rs.getString("accname"); // ��ȡ�˺�
					if (account.equals(str)) { // �ж������˺��Ƿ��������ݿ�����ȵ��˺�
						search_info = "������Ϣ��ѯ�ɹ���";
						rs = null;
						String sql = "SELECT charname from t_char where accname = "
								+ " '" + str + " '";
						String t = sql;
						rs = sta.executeQuery(sql);
//						while (rs.next()) {
//							int temp = 0;
//							name_arr1[temp] = rs.getString("charname");
//							temp++;
//						}
						while (rs.next()) {
							character_name = rs.getString("charname"); // ����ȡ���������ִ���character_name
						}
						break; // ����ѯ�ɹ� ����ѭ�� break
					} else {
						search_info = "��ѯʧ�ܣ������˺��Ƿ���ȷ��";
						continue; // ��ѯʧ�ܣ�continue
					}
				}
			} else {
				search_info = "�����������ݿ⣬�ٽ��в�ѯ��";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		for (int i = 0; i < name_arr1.length; i++) {
//			name_arr[i] = name_arr1[i];
//		}
	}

	private static void name_list(Vector<String> name_list1) {
		// TODO Auto-generated method stub

	}

	// �����ֲ�ѯ����
	public static void Search_by_Char(String str) {

		String name_str;
		try {
			name_str = new String(str.getBytes("GBK"), "latin1"); // ������������ת��Ϊlatin1
			try {
				if (sta != null) {
					rs = sta.executeQuery("SELECT charname from t_char"); // ��ѯ���ݿ��е���������
					while (rs.next()) {
						character = rs.getString("charname"); // �����ִ���character

						if (character.equals(name_str)) { // ���ݿ��������� character
															// �Ƿ�����������ͬ
							search_info = "�����ѯ��Ϣ�ɹ���";
							rs = null;
							String sql = "SELECT accname from t_char where charname = "
									+ " '" + name_str + " '"; // ��ѯ�˺�sql���
							rs = sta.executeQuery(sql);
							while (rs.next()) {
								character_account = rs.getString("accname"); // ����ȡ���˺�character_account
							}
							break; // ����ѯ�ɹ� ����ѭ�� break
						} else {
							search_info = "��ѯʧ�ܣ����������Ƿ���ȷ��";
							continue; // ��ѯʧ�ܣ�continue
						}
					} // ��ȡ�˺�

				} else {
					search_info = "�����������ݿ⣬�ٽ��в�ѯ��";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

	}

	// ************************* �������ֺ��� **********************************
	// ************************* ������Ϣ��ѯ **********************************
	// **************************************************************************

	// ���� ��ѯ����
	public static String Name_Search(String account) {

		String str_name = null;
		String sign = null;
		if (sta != null) {
			try {
				String sql = "SELECT charname from t_char where accname ="
						+ "'" + account + "'";
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("charname");
					try {
						str_name = new String(sign.getBytes("latin1"), "GBK");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return str_name;

	}

	// ����ֵ ��ѯ ����
	public static String Lil_Search(String account) {
		String sign = null;
		if (sta != null) {
			String sql = "SELECT str from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("str");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ��Ϸ�Ҳ�ѯ����
	public static String Money_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT vmoney from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("vmoney");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���� �ȼ���ѯ����
	public static String Ch_level_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT level from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("level");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���� ��ѯ����
	public static String Lingq_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT spr from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("spr");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// �ƶ�ֵ ��ѯ����(���������⣡�� �ֶ�����ȷ��)
	public static String Shane_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT strikepoint from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("strikepoint");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ����ֵ ��ѯ ����
	public static String Jingl_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT enegry from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("enegry");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ����ֵ ��ѯ ����
	public static String Til_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT con from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("con");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ɱ��ֵ ��ѯ ����
	public static String Shaq_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT facecolor from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("facecolor");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ����ֵ ��ѯ
	public static String Huol_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT vigor from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("vigor");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ����ֵ ��ѯ ����
	public static String Dingl_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT ipr from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("ipr");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���� ��ѯ ����
	public static String Jingy_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT exp from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("exp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// Ǳ��ֵ ��ѯ ����
	public static String Qiann_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT points from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("points");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// �� ��ѯ ����
	public static String Shenf_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT dex from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("dex");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// Ԫ�� ��ѯ ����
	public static String Yuanb_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT yuanbao from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("yuanbao");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���ɹ��׶� ��ѯ ����
	public static String Menp_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT menpaipoint from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("menpaipoint");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// �Ա� ��ѯ ����
	public static String Xingb_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT sex from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("sex");
					if (sign.equals("1")) {
						sign = "��";
					}
					if (sign.equals("0")) {
						sign = "Ů";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���� ��ѯ ����
	public static String Zengd_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT zengdian from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("zengdian");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// X ���� ��ѯ ����
	public static String Zuob_X_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT xpos from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("xpos");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// Z ���� ��ѯ ����
	public static String Zuob_Z_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT zpos from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("zpos");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ���� ID ��ѯ ����
	public static String Renw_ID_Search(String account) {

		String sign = null;
		if (sta != null) {
			String sql = "SELECT charguid from t_char where accname =" + "'"
					+ account + "'";
			try {
				rs = sta.executeQuery(sql);
				if (rs.next()) {
					sign = rs.getString("charguid");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

	// ȷ�� �޸� ����
	// ˼·�� ��text �����ݱ���һ�飬ȫ������ ���� �����޸ĵĲ���
	public static void Sure_Change(String name_value, String liliang_value,
			String money_value, String dengji_value, String lingqi_value,
			String shane_value, String jingli_value, String tili_value,
			String shaqi_value, String huoli_value, String dingli_value,
			String jingyan_value, String qianneng_value, String shenfa_value,
			String yuanbao_value, String menpai_value, String xingbie_value,
			String zengdian_value, String zuobiao_x_value,
			String zuobiao_z_value, String renwuID_value, String srt_account) {
		String id_name = null;
		String value = null;
		String search_account = null;
		if (account != null) {
			search_account = account;
		} else if (account == null) {
			search_account = srt_account;
		}
		// �����޸�
		String info[] = { "name_str", "liliang_str", "money_str", "dengji_str",
				"lingqi_str", "shane_str", "jingli_str", "tili_str",
				"shaqi_str", "huoli_str", "dingli_str", "jingyan_str",
				"qianneng_str", "shenfa_str", "yuanbao_str", "menpai_str",
				"xingbie_str", "zengdian_str", "zuobiao_x_str",
				"zuobiao_z_str", "renwuID_str" };
		// ���� ת�� �����⣬�������е��ַ� ���ܳɹ�ת��Ϊ latin1
		for (int i = 0; i < info.length; i++) {
			if (info[i].equals("name_str")) {
				id_name = "charname";
				String name_str = null;
				try {
					name_str = new String(name_value.getBytes("GBK"), "latin1");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				value = name_str;
			}
			if (info[i].equals("liliang_str")) {
				id_name = "str";
				value = liliang_value;
			}

			if (info[i].equals("money_str")) {
				id_name = "vmoney";
				value = money_value;
			}

			if (info[i].equals("dengji_str")) {
				id_name = "level";
				value = dengji_value;
			}

			if (info[i].equals("lingqi_str")) {
				id_name = "spr";
				value = lingqi_value;
			}

			if (info[i].equals("shane_str")) {
				id_name = "strikepoint";
				value = shane_value;
			}

			if (info[i].equals("jingli_str")) {
				id_name = "enegry";
				value = jingli_value;
			}
			if (info[i].equals("tili_str")) {
				id_name = "con";
				value = tili_value;
			}
			if (info[i].equals("shaqi_str")) {
				id_name = "facecolor";
				value = shaqi_value;
			}
			if (info[i].equals("huoli_str")) {
				id_name = "vigor";
				value = huoli_value;
			}
			if (info[i].equals("dingli_str")) {
				id_name = "ipr";
				value = dingli_value;
			}
			if (info[i].equals("jingyan_str")) {
				id_name = "exp";
				value = jingyan_value;
			}
			if (info[i].equals("jingyan_str")) {
				id_name = "exp";
				value = jingyan_value;
			}
			if (info[i].equals("qianneng_str")) {
				id_name = "points";
				value = qianneng_value;
			}
			if (info[i].equals("shenfa_str")) {
				id_name = "dex";
				value = shenfa_value;
			}
			if (info[i].equals("yuanbao_str")) {
				id_name = "yuanbao";
				value = yuanbao_value;
			}
			if (info[i].equals("menpai_str")) {
				id_name = "menpaipoint";
				value = menpai_value;
			}
			if (info[i].equals("xingbie_str")) {
				id_name = "sex";
				value = xingbie_value;
				if (value.equals("��")) {
					value = "1";
				}
				if (value.equals("Ů")) {
					value = "0";
				}
			}
			if (info[i].equals("zengdian_str")) {
				id_name = "zengdian";
				value = zengdian_value;
			}
			if (info[i].equals("zuobiao_x_str")) {
				id_name = "xpos";
				value = zuobiao_x_value;
			}
			if (info[i].equals("zuobiao_z_str")) {
				id_name = "zpos";
				value = zuobiao_z_value;
			}
			if (info[i].equals("renwuID_str")) {
				id_name = "charguid";
				value = renwuID_value;
			}
			String sql = "update t_char set " + id_name + " = " + "'" + value
					+ "'" + " where accname = " + "'" + search_account + "'";
			System.out.println(sql);
			if (sta != null) {
				try {
					sta.execute(sql);
					sure_info = "������Ϣ�޸ĳɹ�";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (sta == null) {
				sure_info = "�����������ݿ⣬�ٽ����޸ģ�";
			}

		}
	}

	// ���ٶ��� ����
	public static void closeMySQL() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
		if (sta != null) {
			sta.close();
			sta = null;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}

	// main����
	public static void main(String[] args) {
		new Test_GM();
		try {
			closeMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
