# KioskApp
Web-based Java Swing Kiosk Application
Ref:https://dzone.com/articles/web-based-java-swing-kiosk-application

A simple Kiosk application using JXBrowser to limit users from accessing all the underling contents and just giving access to the tabs we specify.


## Kiosk App Requirements
There are a lot of techniques and instruments you can use to build kiosk applications. Usually, the main requirement for a kiosk application is that it should not allow end users to switch to other applications running in the environment (administrators might be able to interact with other software, but not the end users). So, you need to display an undecorated full-screen window that will not allow end users to interact with other software installed and running in this environment.

## Creating a Kiosk Using Java Swing
Using Java Swing GUI it’s pretty simple to create a cross-desktop kiosk application. All you need to do is create javax.swing.JFrame instance, make it full screen/maximized, non-resizable, topmost, and remove window decorations such as title, window borders, etc. Java Swing API provides all the necessary functionality. The following sample code demonstrates how to create a simple kiosk application using Java Swing:

import javax.swing.*;
import java.awt.*;
public class KioskApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
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

## Displaying Web Content in a Kiosk
The kiosk application built using the code above displays nothing. In order to provide our app with the ability to display web content, we can use a standard Java Swing component (javax.swing.JEditorPane) that allows displaying HTML content, but it has a lot of restrictions and doesn’t always correctly display web content based on HTML5, CSS3, or JavaScript. Instead, we can use JxBrowser library. JxBrowser allows Java developers to embed a Chromium-based Swing/JavaFX component into a Java application to display web pages built with HTML5, CSS3, JavaScript, Flash, Silverlight, etc.

Let’s modify the code above and bring in the functionality that allows displaying web content. We will add two buttons: Google and BBC News. When a user presses the Google button, we will have the application show the Google search web page. When the user presses the BBC News button, the application will show the BBC News home page where a user can read the latest news.

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class KioskApp {
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
        JButton bbcButton = new JButton("BBC News");
        bbcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.loadURL("http://www.bbc.com/news");
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

Since Java Swing and JxBrowser support touch screens, your kiosk application can be deployed in the environment with touch screen support as well as on the locked-down desktop stations.

## Conclusion
Using this approach based on Java Swing GUI Toolkit + JxBrowser, you can build cross-desktop kiosk applications that allow end users to interact with the web-based content. You can display different websites, web portals, web-based online help systems, etc.

So, if you have the following requirements for your kiosk application, then the approach described in this article is well-recommended:

The kiosk application must run on Windows, Mac OS X, and Linux platforms.

The kiosk application must be built with Java Swing or JavaFX frameworks.

The kiosk application must display HTML5/CSS/JavaScript web content and web pages online/offline.

The kiosk application must support touch screens.

