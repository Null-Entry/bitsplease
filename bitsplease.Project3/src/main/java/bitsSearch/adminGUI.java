

package bitsSearch;

import bitsSearch.models.IndexFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class adminGUI {
    private List<IndexFile> files = new ArrayList<>();
    private Gson gson = new Gson();

    public adminGUI() throws IOException {

        // create window
        Container con = new Container();
        JFrame adminWindow = new JFrame("GUI Admin");

        //set fonts
        Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
        Font anchorFont = new Font("Times New Roman", Font.PLAIN, 16);

        // set layout and resolution

        adminWindow.setSize(800, 600);
        /*
         *  Turns out when you close the admin window, the search window
         *  also closes. To stop this, we change EXIT_ON_CLOSE to
         *  DISPOSE_ON_CLOSE.
         */
        adminWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);

        // make content pane
        con = adminWindow.getContentPane();

        // add title
        JLabel titleLabel = new JLabel("BitsPlease Search Engine");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);

        // adding table
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(180, 200, 400, 200);
        con.add(tablePanel);
        JTable table = new JTable(3, 3);
        table.getColumnModel().getColumn(0).setHeaderValue("File Name");
        table.getColumnModel().getColumn(1).setHeaderValue("File Status");
        table.getColumnModel().getColumn(2).setHeaderValue("File Date");
        JScrollPane sp = new JScrollPane(table);
        tablePanel.add(sp);
        tablePanel.setVisible(true);

        // add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(200, 400, 400, 50);
        con.add(buttonPanel);
        JButton addFile = new JButton("Add File");
        JButton updateFile = new JButton("Update");
        JButton removeFile = new JButton("Remove File");
        buttonPanel.add(addFile);
        buttonPanel.add(updateFile);
        buttonPanel.add(removeFile);

        // adds flavor text
        JPanel anchorPanel = new JPanel();
        anchorPanel.setBounds(200, 500, 400, 50);
        JLabel anchorText = new JLabel("Searching since 2021");
        anchorText.setFont(anchorFont);
        anchorPanel.add(anchorText);
        con.add(anchorPanel);
        load();

        // add button on click
        // select file dialoge
        // add index file to above list (this.files)
        // call save
    }

    private void save() throws IOException {
        File f = new File("files.json");
        try (FileWriter bw = new FileWriter(f)) {
            String raw = gson.toJson(this.files);
            bw.write(raw);
        }
    }
    // sam

    private void load() throws IOException {
        File f = new File("files.json");
        if (!f.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try (FileReader bw = new FileReader(f)) {
          try(BufferedReader reader = new BufferedReader(bw)){
             String line;
             while((line = reader.readLine()) != null){
                 sb.append(line);
             }
         }
        }
        Type collectionType = new TypeToken<ArrayList<IndexFile>>(){}.getType();
        this.files = gson.fromJson(sb.toString(), collectionType);
    }

    public static void main(String[] args) {
        adminGUI admin = new adminGUI();
    }
}