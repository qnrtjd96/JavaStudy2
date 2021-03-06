import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class TextUpdate_Delete_Tea extends JFrame implements ActionListener, ItemListener{
	
	JPanel mainCenterPane = new JPanel(new BorderLayout());
		JPanel  topPane = new JPanel(new BorderLayout());
	    JPanel topPane1 = new JPanel(new GridLayout(0, 2));
	    	JLabel cate = new JLabel("카테고리     ");
	    	JLabel cate2 = new JLabel("요리");
	    	JPanel topPane2 = new JPanel(new GridLayout(0, 2));
			JLabel  area = new JLabel("지역");
			JComboBox<String> area2 = new JComboBox<String>();
			DefaultComboBoxModel<String> area2Model = new DefaultComboBoxModel<String>();
			    String area2Str[]= {"경기도","서울특별시","대구광역시","울산광역시","부산광역시","인천광역시","경상남도","경상북도","전라남도","전라북도","충청남도","충청북도","제주도"};
	    JPanel formLabelPane = new JPanel(new GridLayout(6, 1));
		    JLabel classname = new JLabel("클래스명");
		    JLabel classdetail = new JLabel("간단한 클래스 소개");
		    JLabel total = new JLabel("경력사항");
		    JLabel detail = new JLabel("상세지역");
		    JLabel  pay = new JLabel("비용(1회당)");
		    JLabel  time = new JLabel("수업시간");
		    
	    JPanel formCenterPane = new JPanel(new GridLayout(6, 1));
		    JTextArea classname2 = new JTextArea();
		    JTextArea classdetail2 = new JTextArea();
		    JTextArea total2 = new JTextArea();
		    JTextArea detail2 = new JTextArea();
		    JTextArea pay2 = new JTextArea();
		    
		    JPanel time2 = new JPanel(new GridLayout(4, 3));
	    		String classTime[] = {"09:00~10:00","10:00~11:00","11:00~12:00",
	    							   "12:00~13:00","13:00~14:00","14:00~15:00",
	    							   "15:00~16:00","16:00~17:00","17:00~18:00",
	    							   "18:00~18:00","20:00~21:00","21:00~22:00"};
	    JPanel mainBottomPane = new JPanel(new BorderLayout());
	    	JPanel buttonPane = new JPanel();
			     JButton updateBtn = new JButton("수정하기");
			     JButton deleteBtn = new JButton("삭제하기");
	
	public TextUpdate_Delete_Tea() {
		//상단패널
		for(String Name : area2Str) {
			area2Model.addElement(Name);
		}
		area2.setModel(area2Model);
		area2.setSelectedItem(area); //이거바꿔줘야함
		
		topPane1.add(cate); topPane1.add(cate2);
        topPane.add("West", topPane1);
        topPane2.add(area); topPane2.add(area2);
        topPane.add("East", topPane2);
        mainCenterPane.add("North", topPane);
        
        //센터패널
        for(int i=0; i<classTime.length; i++ ) {
        	JCheckBox box = new JCheckBox(classTime[i]);
        	box.setBackground(Color.white);
        	box.addItemListener(this);
        	time2.add(box);
        }
        
        classname.setBorder(new LineBorder(Color.black, 1));	classname2.setBorder(new LineBorder(Color.black, 1));
        classdetail.setBorder(new LineBorder(Color.black, 1));	classdetail2.setBorder(new LineBorder(Color.black, 1));
        total.setBorder(new LineBorder(Color.black, 1));		total2.setBorder(new LineBorder(Color.black, 1));
        detail.setBorder(new LineBorder(Color.black, 1));		detail2.setBorder(new LineBorder(Color.black, 1));
        pay.setBorder(new LineBorder(Color.black, 1));			pay2.setBorder(new LineBorder(Color.black, 1));
        time.setBorder(new LineBorder(Color.black, 1));			time2.setBorder(new LineBorder(Color.black, 1));
        
        formLabelPane.add(classname);	formCenterPane.add(classname2);
        formLabelPane.add(classdetail);	formCenterPane.add(classdetail2);
        formLabelPane.add(total);		formCenterPane.add(total2);
        formLabelPane.add(detail);		formCenterPane.add(detail2);
        formLabelPane.add(pay);			formCenterPane.add(pay2);
        formLabelPane.add(time);		formCenterPane.add(time2);
        mainCenterPane.add("West", formLabelPane);
        mainCenterPane.add("Center", formCenterPane);
        mainCenterPane.setBorder(new LineBorder(Color.black, 1));
        
        //남쪽패널
        buttonPane.add(updateBtn);
        buttonPane.add(deleteBtn);
    
        mainBottomPane.add("East", buttonPane);
        mainCenterPane.add("South", mainBottomPane);
        
        //////////패널추가
        //사이즈와 보여주기 ---설정들
  		setSize(800,1000);
  		setVisible(true);
  		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new TextUpdate_Delete_Tea();
	}

}
