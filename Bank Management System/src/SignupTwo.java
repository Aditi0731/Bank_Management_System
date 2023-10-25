import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religion, category, occupation, education,income;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;

        setLayout(null);//By default border layout karta hai isliye  setlayout ko null karna hai

        setTitle("New Account Information Form-PAGE 2");


        JLabel additionalDetails=new JLabel("Page 1:Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel category1=new JLabel("Category:");
        category1.setFont(new Font("Raleway",Font.BOLD,20));
        category1.setBounds(100,190,200,30);
        add(category1);

        String valcategory[]={"General", "OBC", "SC", "ST", "Other"};
        category =new JComboBox(valcategory);
        category .setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);


        JLabel income1=new JLabel("Income:");
        income1.setFont(new Font("Raleway",Font.BOLD,20));
        income1.setBounds(100,240,200,30);
        add(income1);

        String incomecategory[]={"Null", "<1,50,000", "<2,50,000", "Upto 10,00,000"};
        income =new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);


        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String educationvalues[]={"Non Graduation", "Graduate", "Post Graduation", "Doctorate","Other"};
        education =new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel occupational=new JLabel("Occupation:");
        occupational.setFont(new Font("Raleway",Font.BOLD,20));
        occupational.setBounds(100,390,200,30);
        add( occupational);

        String occupationalvalues[]={"Salaried", "Self Employed", "Business", "Student","Retire","Others"};
        occupation =new JComboBox(occupationalvalues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address =new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add( address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);


        JLabel aadharn=new JLabel("Aadhar Number:");
        aadharn.setFont(new Font("Raleway",Font.BOLD,20));
        aadharn.setBounds(100,490,200,30);
        add(aadharn);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add( state);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);


        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);


        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);


        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.white);// getContentPane pooora frame utha k deta hai

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorCitizen=null;
        if(syes.isSelected())
        {
            seniorCitizen ="Yes";
        } else if (sno.isSelected()) {
            seniorCitizen="No";
        }


        String existingAccount=null;
        if(eyes.isSelected())
        {
            existingAccount="Yes";
        } else if (eno.isSelected()) {
            existingAccount="No";
        }

        String span= pan.getText();
        String saadhar=aadhar.getText();


        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query);

            //Signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }



    }




    public static void main(String[] args)
    {
        new SignupTwo("");
    }
}
