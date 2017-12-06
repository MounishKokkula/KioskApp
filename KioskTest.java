import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class KioskTest {
    public static void main(String[] args) {
        // Create Browser instance
        final Browser browser = new Browser();
        // Create Google and BBC News buttons
        JButton googleButton = new JButton("Google");
        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.loadURL("https://www.google.com");
            }
        });
        JButton bbcButton = new JButton("Weather");
        bbcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.loadURL("https://www.accuweather.com/en/us/villanova-pa/19085/current-weather/330284");
            }
        });
        JPanel actionPane = new JPanel();
        actionPane.add(googleButton);
        actionPane.add(bbcButton);
        JFrame frame = new JFrame();
        frame.add(actionPane, BorderLayout.WEST);
        frame.add(new BrowserView(browser), BorderLayout.CENTER);
        // Remove window title and borders
        frame.setUndecorated(true);
        // Make frame topmost
        frame.setAlwaysOnTop(true);
        // Disable Alt+F4 on Windows
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        // Make frame full-screen
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        // Display frame
        frame.setVisible(true);
    }
}