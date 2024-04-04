package ornify;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.JApplication;

public class BaseApplication extends JApplication implements ActionListener
{
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;

  protected static final String ABOUT = "About";
  protected static final String LOAD = "Load";
  protected static final String START = "Start";

  private JPanel titlePanel;

  public BaseApplication(String[] args)
  {
    super(args, WIDTH, HEIGHT);
  }

  public void actionPerformed(ActionEvent evt)
  {
    switch (evt.getActionCommand())
    {
      case LOAD:
        break;
      case ABOUT:
        break;
      case START:
        handleStart();
        break;
      default:
        break;
    }
  }

  /**
   * Method that controls the start button action.
   * 
   * @throws IOException
   */
  protected void handleStart()
  {
    JPanel panel = (JPanel) this.getContentPane();
    panel.remove(titlePanel);
    panel.revalidate();
    panel.repaint();
  }

  @Override
  public void init()
  {
    // Add the panel to the main window
    JPanel panel = (JPanel) this.getContentPane();
    panel.setLayout(null);

    JLabel title = new JLabel("Ornify");
    title.setFont(new Font("Verdana", Font.BOLD, 30));

    title.setBounds((WIDTH / 2) - 50, 50, 200, 100);

    this.titlePanel = new JPanel();
    titlePanel.setLayout(null);
    titlePanel.setBounds(0, 0, WIDTH, HEIGHT);

    JButton startButton = new JButton(START);
    startButton.setBounds((WIDTH / 2) - 50, (HEIGHT / 2) + 200, 100, 50);
    startButton.addActionListener(this);

    // Add to the title panel
    titlePanel.add(title);
    titlePanel.add(startButton);
    titlePanel.setVisible(true);

    // Add everything to the main panel
    // panel.add(label);
    panel.add(titlePanel);
  }

  public static void main(String[] args)
  {
    JApplication app = new BaseApplication(args);
    invokeInEventDispatchThread(app);
  }
}
