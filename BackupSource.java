/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejtablestat;


import java.util.regex.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.ProcessBuilder.Redirect.from;
import java.sql.*;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arunav Mallik Avi Arm_AVI
 */
public class DBJtableTestLoad extends javax.swing.JFrame {

    public Connection con = null;
    public PreparedStatement stmt = null;
    public ResultSet rs = null;
    DefaultTableModel dm;

    public void mySqlconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users", "root", "");
        } catch (Exception e) {
        }
    }
    
 
     
    

    public ArrayList<User> ListUsers(String ValToSearch) {
        ArrayList<User> usersList = new ArrayList<User>();

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`id`, `Name`,`Age`,`Gender`,`BirthPlace`,`Fathername`,`Mothername`,`Address`,`Email`,`PostCode`,`CourseName`,`Semester`,`AddmissionYear`,`Contact`,`Birthdate`) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            User user;

            while (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("Name"),
                        rs.getString("age"),
                        rs.getString("Gender"),
                        rs.getString("BirthPlace"),
                        rs.getString("Fathername"),
                        rs.getString("Mothername"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("PostCode"),
                        rs.getString("CourseName"),
                        rs.getString("Semester"),
                        rs.getString("AddmissionYear"),
                        rs.getString("Contact"),
                        rs.getString("Birthdate")
                       
                        
                      
                        
                        
                );
                usersList.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return usersList;
    }

    public void findUsers() {
        ArrayList<User> users = ListUsers(searchAd.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"id", "Name", "Age","gender","birthPlace","fatherName","motherName","address","Email","PostCode","CourseName","Semester","AddmissionYear","Contact","Birthdate"});
        Object[] row = new Object[20];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getid();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getAge();
            row[3] = users.get(i).getGender();
            row[4] = users.get(i).getbirthPlace();
            row[5] = users.get(i).getfatherName();
            row[6] = users.get(i).getmotherName();
            row[7] = users.get(i).getaddress();
            row[8] = users.get(i).getEmail();
            row[9] = users.get(i).getPostCode();
           
            row[10] = users.get(i).getCourseName();
            row[11] = users.get(i).getSemester();
            row[12] = users.get(i).getAddmissionYear();
            row[13] = users.get(i).getContact();
            row[14] = users.get(i).getBirthdate();
         
            model.addRow(row);
        }
        tblLoad.setModel(model);

    }

    public void fetch() {
        try {

            //Class.forName("com.mysql.jdbc.Driver");  
            //con = DriverManager.getConnection(  
            //"jdbc:mysql://localhost:3306/users","root","");
            //PreparedStatement stmt;
            mySqlconnection();
            String sqlSelec = "select * from users";
            stmt = con.prepareStatement(sqlSelec);
            rs = stmt.executeQuery();
            //Statement stmt = (PreparedStatement) con.createStatement();  
            //ResultSet rs = stmt.executeQuery("select * from users"); 

            TableModel model = DbUtils.resultSetToTableModel(rs);
            tblLoad.setModel(model);
        } catch (Exception e) {
            System.out.println("connection error");
        }
    }
    
    
  
           
           
    public DBJtableTestLoad() {
        initComponents();
        fetch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoad = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        serId = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        searchAd = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        idIn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maleRad = new javax.swing.JRadioButton();
        femaleRad = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameIn = new javax.swing.JTextField();
        ageIn = new javax.swing.JTextField();
        transSxRad = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        fatherName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        motherName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lbl_img = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        postCode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        contactNo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        genderDisp = new javax.swing.JTextField();
        semesterTxt = new javax.swing.JTextField();
        dobDisp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        admyearDisp = new javax.swing.JTextField();
        dirthDisp = new javax.swing.JTextField();
        birthComSel = new javax.swing.JComboBox<>();
        courseCombo = new javax.swing.JComboBox<>();
        courseTxt = new javax.swing.JTextField();
        semesterCombo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblLoad.setBackground(new java.awt.Color(204, 204, 204));
        tblLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoad);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Student"));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel6.setText("Search By ID:");

        serId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serIdActionPerformed(evt);
            }
        });
        serId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serIdKeyReleased(evt);
            }
        });

        search.setBackground(new java.awt.Color(153, 153, 153));
        search.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel7.setText("Advance Search:");

        searchAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAdActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 102, 0));
        jButton5.setFont(new java.awt.Font("Leelawadee UI", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ad Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serId, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchAd, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(search)
                                    .addComponent(serId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addComponent(searchAd, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("id: ");

        idIn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        idIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setText("Gender:");

        buttonGroup1.add(maleRad);
        maleRad.setText("Male");
        maleRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleRad);
        femaleRad.setText("Female");
        femaleRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Name : ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Age :");

        nameIn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        ageIn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        buttonGroup1.add(transSxRad);
        transSxRad.setText("Other / Trans SX");
        transSxRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transSxRadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Birth Date: ");

        dob.setBackground(new java.awt.Color(255, 102, 0));
        dob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dobMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setText("Father Name : ");

        fatherName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setText("Mother Name :");

        motherName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        motherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherNameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setText("Address : ");

        address.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Image Pane"));

        jDesktopPane2.setBackground(new java.awt.Color(0, 0, 0));

        lbl_img.setIcon(new javax.swing.ImageIcon("G:\\Moomi Appie.jpg")); // NOI18N

        jDesktopPane2.setLayer(lbl_img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        jButton6.setBackground(new java.awt.Color(255, 102, 0));
        jButton6.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add Image");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setText("Email :");

        email.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel13.setText("Post Code :");

        postCode.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel14.setText("Contact No : ");

        contactNo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel16.setText("Department :");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setText("Semester :");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel18.setText("Addmission Year : ");

        semesterTxt.setEditable(false);
        semesterTxt.setBackground(new java.awt.Color(255, 153, 102));
        semesterTxt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        semesterTxt.setForeground(new java.awt.Color(0, 0, 0));

        dobDisp.setEditable(false);
        dobDisp.setBackground(new java.awt.Color(255, 153, 102));
        dobDisp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        dobDisp.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setText("Birth Place:");

        admyearDisp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        dirthDisp.setEditable(false);
        dirthDisp.setBackground(new java.awt.Color(255, 153, 102));
        dirthDisp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        dirthDisp.setForeground(new java.awt.Color(0, 0, 0));

        birthComSel.setBackground(new java.awt.Color(255, 102, 0));
        birthComSel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        birthComSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Bakerganj", "Barguna", "Bhola", "Char Fasson", "Gaurnadi", "Jhalokati", "Patuakhali", "Pirojpur", "Swarupkati", "Kuakata", "Bandarban", "Khagrachhari", "Rangamati", "Rangunia", "Sandwip", "Fatikchhari", "Nazir Hat", "Baroiyarhat", "Mirsharai", "Sitakunda", "Hathazari", "Raozan", "Patiya", "Chandanaish", "Lohagara", "Satkania", "Boalkhali", "Akhaura", "Sarail", "Chandpur", "Chaumuhani", "Laksam", "Lakshmipur", "Burichong", "Madhabdi", "Mirzapur", "Dhanbari", "Madhupur", "Gopalpur", "Ghatail", "Kalihati", "Sakhipur", "Bhuapur", "Elenga", "Karatia", "Aricha", "Basail", "Bhairab", "Kishoreganj", "Manikganj", "Munshiganj", "Narsingdi", "Gopalganj", "Shariatpur", "Madaripur", "Rajbari", "Khulna Division\t7\t", "Bagherhat", "Chuadanga", "Darshana,Chuadanga", "Jhenaidah", "Magura", "Meherpur", "Narail", "Shatkhira", "Shomvugonj", "Muktagasa", "Bhaluka", "Gouripur", "Phulpur", "Trishal", "Nandail", "Gofargaon", "Ishwargonj", "Haluaghat", "Fulbaria", "Netrokona", "Sherpur", "Joypurhat", "Kalai", "Khetlal", "Akkelpur", "Panchbibi", "Mundumala", "Naogaon", "Natore", "Shahjadpur", "Ullapara", "Iswardi", "Santhia", "Sherpur,Bogra", "Tanore", "Pabna", "Gaibandha", "Kurigram", "Lalmonirhat", "Nilphamari", "Panchagarh", "Thakurgaon", "Saidpur", "Golapganj", "Habiganj", "Maulvibazar", "Sreemangal", "Sunamganj (town)", "Beanibazar", "Barlekha", "Zakiganj", "Chhatak" }));

        courseCombo.setBackground(new java.awt.Color(255, 102, 0));
        courseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Computer Science & Engineering", "Electrical & Electronics Engineering", "Nuclear Engineering", "Information & Comunnication Technology", "Mathmatics & Informatics", "Aeronotics & Aircraft Engineering", "Astrophysics", "Applied Physics", "Industrial & Production Enginnering", "Cognitive Science", "Bioinformatics", "Mechatronics Enginnering", "Mechanical Engineering" }));
        courseCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseComboItemStateChanged(evt);
            }
        });

        courseTxt.setEditable(false);
        courseTxt.setBackground(new java.awt.Color(255, 153, 102));
        courseTxt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        courseTxt.setForeground(new java.awt.Color(0, 0, 0));

        semesterCombo.setBackground(new java.awt.Color(255, 102, 0));
        semesterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1st Semeste", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" }));
        semesterCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semesterComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idIn)
                                    .addComponent(nameIn)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(maleRad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(femaleRad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(transSxRad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(genderDisp, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dobDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fatherName, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                        .addComponent(motherName))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)
                                .addComponent(dirthDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(birthComSel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12))
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(semesterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semesterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addGap(3, 3, 3)
                                .addComponent(admyearDisp))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(postCode, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(3, 3, 3)
                                .addComponent(contactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(courseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idIn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageIn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(dirthDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthComSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maleRad)
                            .addComponent(femaleRad)
                            .addComponent(transSxRad)
                            .addComponent(jLabel8)
                            .addComponent(genderDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(dobDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(motherName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postCode, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(courseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(admyearDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(semesterTxt)
                        .addComponent(jLabel17)
                        .addComponent(semesterCombo)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation Panel"));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 0));
        jButton4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RELOAD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jButton7.setBackground(new java.awt.Color(255, 102, 0));
        jButton7.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon("F:\\Android Projects\\Images For Applicaion\\fav11.PNG")); // NOI18N
        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jMenu1.setText("Option");

        jMenuItem4.setText("Admin Manager");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Clear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1245, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //int idGet = Integer.parseInt(idIn.getText());
        String idGet = idIn.getText();
        String nameGet = nameIn.getText();
        String ageGet = ageIn.getText();
        int postGet = Integer.parseInt(postCode.getText());
        String addmissionGet = admyearDisp.getText();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String startDateString = dateFormat.format(dob.getDate());
         
         if(dob.getDate() == null){
          JOptionPane.showMessageDialog(null, "Select BirthDate !");
         }else{
             //dob.getDate().toString();
           //startDateString = dateFormat.format(dob.getDate().toString());
         }
         
         //java.sql.Date sqldate = new java.sql.Date(dob.getDate().getTime());
        
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String startDateString = dateFormat.format(dob.getDate());
        
        /*
          if(dob.getDate()==null){
              JOptionPane.showMessageDialog(null, "Select BirthDate !");
          }
         */
        
        //ID Alert
        /*
        if (idIn.getText().equals(null)) {
            JOptionPane.showMessageDialog(null, "Enter ID !");
         }
        
        //Name Alert
      else if (nameIn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Name !");
         }
         
      else  if (ageIn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Age !");
         } 
        
       else  if (fatherName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Father Name !");
         } 
         
       else  if (motherName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Mother Name !");
         } 
         
       else  if (address.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Address !");
         } 
         
       else  if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Email !");
         } 
         
        else if (postCode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Post Code !");
         } 
         
        else if (courseTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Department !");
         } 
         
        else if (semesterTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Semester !");
         } 
        
        else if (admyearDisp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Year !");
         } 
         
        else if(idIn.getText().equals("") && ageIn.getText().equals("") && fatherName.getText().equals("") && motherName.getText().equals("") && address.getText().equals("") && email.getText().equals("") && courseTxt.getText().equals("") && semesterTxt.getText().equals("") && admyearDisp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Some Field is Missing !");
         }
        else {
        JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Add Information In DateBase !");
        
        }
        */
        /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = dateFormat.format(dob.getDate());
         
         if(startDateString == null){
          JOptionPane.showMessageDialog(null, "Select BirthDate !");
         }else{
           startDateString = dateFormat.format(dob.getDate());
         }
         */
      
         
         
         
        /*
       DefaultTableModel model = (DefaultTableModel) tblLoad.getModel();
       model.addRow(new Object[]{idIn.getText(), nameIn.getText(),ageIn.getText()});
         */
     
      try {
            mySqlconnection();
            String query = String.format("select * from users where id = %s", idGet);
            rs = stmt.executeQuery(query);
     
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "This Record is Already Exists!");
            } else {
                //String sqlInsert = "insert into users (id,Name,Age,Gender,BirthPlace,Fathername,Mothername,Address,Email,PostCode,CourseName,Semester,AddmissionYear,Contact,Birthdate,image)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                 
                
                 String sqlInsert ="insert into users " 
                        + "(id,Name,Age,Gender,"
                        + "BirthPlace,Fathername,"
                        + "Mothername,Address,Email,"
                        + "PostCode,CourseName,Semester,AddmissionYear,Contact,Birthdate,image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                
                
                
                
                
                
                
                
                stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, idGet);
                stmt.setString(2, nameGet);
                stmt.setString(3, ageGet);
                stmt.setString(4, gender);
                stmt.setString(5, birthComSel.getSelectedItem().toString());
                //stmt.setBytes(6, person_image);
                stmt.setString(6, fatherName.getText());
                stmt.setString(7, motherName.getText());
                stmt.setString(8, address.getText());
                stmt.setString(9, email.getText());
                stmt.setInt(10, postGet);
               
                stmt.setString(11, courseTxt.getText());
                stmt.setString(12, semesterTxt.getText());
                stmt.setString(13, addmissionGet);
                stmt.setString(14, contactNo.getText());
                stmt.setString(15, dateFormat.format(dob.getDate()));
                //stmt.setString(14, contactNo.getText());
                stmt.setBytes(16, person_image);
                stmt.execute();
                rs = stmt.executeQuery();
            }

        } catch (Exception e) {
            System.out.println(e);
                    }
      

        fetch();

    }                                        

    private void tblLoadMouseClicked(java.awt.event.MouseEvent evt) {                                     
         int selRow = tblLoad.getSelectedRow();
        TableModel model = tblLoad.getModel();
        String TableClick = (tblLoad.getModel().getValueAt(selRow, 0).toString());
        idIn.setText(model.getValueAt(selRow, 0).toString());      //1
        nameIn.setText(model.getValueAt(selRow, 1).toString());    //2
        ageIn.setText(model.getValueAt(selRow, 2).toString());     //3
        //genderDisp.setText(model.getValueAt(selRow, 3).toString());
        dirthDisp.setText(model.getValueAt(selRow, 4).toString());                                                        //Gender 4
       
        
        fatherName.setText(model.getValueAt(selRow, 5).toString()); //5
        motherName.setText(model.getValueAt(selRow, 6).toString()); //6
        address.setText(model.getValueAt(selRow, 7).toString());    //7
        email.setText(model.getValueAt(selRow, 8).toString());      //8
        postCode.setText(model.getValueAt(selRow, 9).toString());   //9
      
       
        courseTxt.setText(model.getValueAt(selRow, 10).toString());    //10
        semesterTxt.setText(model.getValueAt(selRow, 11).toString()); //11
        admyearDisp.setText(model.getValueAt(selRow, 12).toString()); //12 
        contactNo.setText(model.getValueAt(selRow, 13).toString());   //13
        dobDisp.setText(model.getValueAt(selRow, 14).toString());
       
        
         try {
            String sqlImg = String.format("select * from users where id = '"+TableClick+"'");
            stmt = con.prepareStatement(sqlImg);
            rs = stmt.executeQuery();
            if(rs.next()){
            byte[] imageData = rs.getBytes("image");
            format = new ImageIcon(imageData);
            lbl_img.setIcon(format);
            }
        } catch (Exception e) {
        }
        
    }                                    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            try {
            String deleteDb = "DELETE FROM users WHERE id =" + idIn.getText();
            stmt = con.prepareStatement(deleteDb);
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        fetch();
    }                                        

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        idIn.setText("");
        nameIn.setText("");
        ageIn.setText("");
       // path.setText("");
        lbl_img.setIcon(null);
        dirthDisp.setText("");
        genderDisp.setText("");
        dobDisp.setText("");
        fatherName.setText("");
        motherName.setText("");
        address.setText("");        
        email.setText("");
        postCode.setText("");
        contactNo.setText("");
        courseTxt.setText("");
        semesterTxt.setText("");
        admyearDisp.setText("");        
    }                                          

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       

        int serIdS = Integer.parseInt(serId.getText());
        try {
            String searChId = String.format("select * from users where id = %d", serIdS);
            stmt = con.prepareStatement(searChId);
            rs = stmt.executeQuery();
            TableModel model = DbUtils.resultSetToTableModel(rs);
            tblLoad.setModel(model);

//       String sqlInsert = "insert into users (id,Name,Age)"+ " values (?, ?, ?)";
//       stmt = con.prepareStatement(sqlInsert);
//       stmt.setInt(1, idGet);
//       stmt.setString(2, nameGet);
//       stmt.setInt(3, ageGet);
//       stmt.execute();
//       rs = stmt.executeQuery();
//       
            //   stmt.execute();   
        } catch (Exception e) {
            //System.out.println(e);
            JOptionPane.showMessageDialog(null, "Not Found");
        }


    }                                      

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        fetch();
    }                                        

    private void serIdKeyReleased(java.awt.event.KeyEvent evt) {                                  


    }                                 

    private void serIdActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        findUsers();
    }                                        

    private void searchAdActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void idInActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void maleRadActionPerformed(java.awt.event.ActionEvent evt) {                                        
        gender = "male";
    }                                       

    private void femaleRadActionPerformed(java.awt.event.ActionEvent evt) {                                          
        gender = "female";
    }                                         

    private void transSxRadActionPerformed(java.awt.event.ActionEvent evt) {                                           
       gender = "Other/Trans SX";
    }                                          

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        filename =f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_DEFAULT));
        lbl_img.setIcon(imageIcon);
      try {

            File image = new File(filename);
            FileInputStream fis = new FileInputStream (image);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int readNum; (readNum=fis.read(buf))!=-1; ){

                bos.write(buf,0,readNum);
            }
            person_image=bos.toByteArray();
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
       
       
    }                                        

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       AdminManager manage = new AdminManager();
       manage.setVisible(true);
    }                                          

    private void motherNameActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void semesterComboItemStateChanged(java.awt.event.ItemEvent evt) {                                               
      semesterTxt.setText(semesterCombo.getSelectedItem().toString());
    }                                              

    private void courseComboItemStateChanged(java.awt.event.ItemEvent evt) {                                             
        courseTxt.setText(courseCombo.getSelectedItem().toString());
    }                                            

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int idVal = Integer.parseInt(idIn.getText());
        String idImVal = idIn.getText();
        String nameVal = nameIn.getText();
        String ageVal = ageIn.getText();
        String birthPlaceVal = birthComSel.getSelectedItem().toString();
        int postGet = Integer.parseInt(postCode.getText());
        String getRadVal = "Not Specified";
        int addmissionGet = Integer.parseInt(admyearDisp.getText());
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String  startDateString = dateFormat.format(dob.getDate());
        
      
       // Id Validation
       
        if (dob.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please type birthday", "Warning!", JOptionPane.ERROR_MESSAGE);
        } else {
            dateFormat.format(dob.getDate());
        }
        
        
        
        if(maleRad.isSelected()){
            getRadVal = "male";
        }
        else if(femaleRad.isSelected()){
            getRadVal = "female";
        }
        else if(transSxRad.isSelected()){
            getRadVal = "Other/Trans Sx";
        }

        try {

            //mySqlconnection();
            String update = "UPDATE users SET id='" + idVal + "',Name='" + nameVal + "',Age='" + ageVal + "',Gender = '"+ getRadVal +"',BirthPlace = '"+ birthPlaceVal +"',Fathername = '"+ fatherName.getText() +"',Mothername = '"+ motherName.getText() +"',Address = '"+ address.getText() +"', Email = '"+ email.getText() +"',PostCode = '"+ postGet +"',CourseName = '"+ courseTxt.getText() +"',Semester = '"+ semesterTxt.getText() +"',AddmissionYear = '"+ addmissionGet +"',Contact = '"+ contactNo.getText() +"',Birthdate = '"+ dateFormat.format(dob.getDate()) +"'  WHERE id ='" + idVal + "'";
            stmt = con.prepareStatement(update);
            stmt.executeUpdate();
            //stmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);

        }

        try {

            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] image = new byte[(int)file.length()];
            fis.read(image);
            //path.setText(filename);
            String sqlImgUpdate = "update users SET Image = ? WHERE id ='" + idImVal + "'";
            stmt = con.prepareStatement(sqlImgUpdate);
            stmt.setBytes(1, image);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);

        }

        /*
        try {
            File image = new File(fileName);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum;(readNum = fis.read(buf))!=-1;) {
                bos.write(buf,0,readNum);
            }
            person_image = bos.toByteArray();
            String sqlImgUpdate = "UPDATE users SET Image = ? WHERE id ='" + idVal + "'";
            stmt = con.prepareStatement(sqlImgUpdate);
            stmt.setBytes(1, imageVal);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        */

        fetch();
    }                                        

    private void dobMouseClicked(java.awt.event.MouseEvent evt) {                                 
  
    }                                

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       System.exit(0);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DBJtableTestLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBJtableTestLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBJtableTestLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBJtableTestLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBJtableTestLoad().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField address;
    private javax.swing.JTextField admyearDisp;
    private javax.swing.JTextField ageIn;
    private javax.swing.JComboBox<String> birthComSel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField contactNo;
    private javax.swing.JComboBox<String> courseCombo;
    private javax.swing.JTextField courseTxt;
    private javax.swing.JTextField dirthDisp;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField dobDisp;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fatherName;
    private javax.swing.JRadioButton femaleRad;
    private javax.swing.JTextField genderDisp;
    private javax.swing.JTextField idIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JRadioButton maleRad;
    private javax.swing.JTextField motherName;
    private javax.swing.JTextField nameIn;
    private javax.swing.JTextField postCode;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchAd;
    private javax.swing.JComboBox<String> semesterCombo;
    private javax.swing.JTextField semesterTxt;
    private javax.swing.JTextField serId;
    private javax.swing.JTable tblLoad;
    private javax.swing.JRadioButton transSxRad;
    // End of variables declaration                   

    
    public String gender;
   
    private ImageIcon format =null;
    String filename = null;
    byte[] person_image = null;
}
