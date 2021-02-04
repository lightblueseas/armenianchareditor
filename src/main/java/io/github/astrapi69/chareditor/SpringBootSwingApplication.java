/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.chareditor;

import java.awt.*;
import java.io.File;

import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.plaf.LookAndFeels;
import de.alpharogroup.swing.splashscreen.BaseSplashScreen;
import de.alpharogroup.swing.splashscreen.SplashScreenModelBean;
import de.alpharogroup.throwable.ThrowableExtensions;
import io.github.astrapi69.chareditor.panels.MainPanel;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import de.alpharogroup.swing.base.BaseDesktopMenu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.swing.*;

/**
 * The class {@link SpringBootSwingApplication}
 */
@SuppressWarnings("serial")
@SpringBootApplication
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpringBootSwingApplication extends ApplicationPanelFrame<ApplicationModelBean>
{

	public static ConfigurableApplicationContext ctx;

	/** The instance. */
	private static SpringBootSwingApplication instance;

	JFileChooser jfileChooser;

	/**
	 * Gets the single instance of SpringBootSwingApplication.
	 *
	 * @return single instance of SpringBootSwingApplication
	 */
	public static SpringBootSwingApplication getInstance()
	{
		return instance;
	}

	/**
	 * The main method that start this {@link SpringBootSwingApplication}
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args)

	{
		String imagePath;
		String text;
		imagePath = Messages.getString("global.icon.app.path");
		text = Messages.getString("mainframe.project.name");
		SplashScreenModelBean splashScreenModelBean = SplashScreenModelBean.builder()
		.imagePath(imagePath).text(text).min(0).max(100).showTime(3000)
		.showing(true).build();
			new Thread(()->{
			Model<SplashScreenModelBean> modelBeanModel = BaseModel.of(splashScreenModelBean);
				new BaseSplashScreen(null, modelBeanModel);
		}).start();
		ThrowableExtensions.toRuntimeExceptionIfNeeded(i -> Thread.sleep(splashScreenModelBean.getShowTime()));

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(
			SpringBootSwingApplication.class).headless(false).run();
		SpringBootSwingApplication.ctx = ctx;

		EventQueue.invokeLater(() -> {
			SpringBootSwingApplication ex = ctx.getBean(SpringBootSwingApplication.class);
			ex.setVisible(true);

			if (instance == null)
			{
				instance = ex;
			}
		});
	}

	public static final String TITLE = Messages
			.getString("TransformerJFrame.title"); //$NON-NLS-1$

	public static final String ISO_8859_7 = Messages
			.getString("TransformerJFrame.iso8859_7"); //$NON-NLS-1$

	public static final String[] columnNames = {
			Messages.getString("TransformerJFrame.column"),
			Messages.getString("TransformerJFrame.column.latin"),
			Messages.getString("TransformerJFrame.column.htmlentitys"), ISO_8859_7}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/**
	 * Instantiates a new main frame.
	 */
	public SpringBootSwingApplication()
	{
		super(Messages.getString("mainframe.title"));
		jfileChooser = new JFileChooser();
	}

	@Override
	protected File newConfigurationDirectory(final @NonNull String parent,
		final @NonNull String child)
	{
		String configurationDirectoryName = "chareditor";
		File applicationConfigurationDirectory = new File(
			super.newConfigurationDirectory(parent, child), configurationDirectoryName);
		if (!applicationConfigurationDirectory.exists())
		{
			applicationConfigurationDirectory.mkdir();
		}
		return applicationConfigurationDirectory;
	}

	@Override
	protected BaseDesktopMenu newDesktopMenu(@NonNull Component applicationFrame)
	{
		return new DesktopMenu(applicationFrame);
	}

	@Override
	protected String newIconPath()
	{
		return Messages.getString("global.icon.app.path");
	}

	@Override
	protected void onAfterInitialize()
	{
		super.onAfterInitialize();

		if (instance == null)
		{
			instance = this;
		}
		setTitle(Messages.getString("mainframe.title"));
	}

	@Override
	protected LookAndFeels newLookAndFeels()
	{
		LookAndFeels metal = LookAndFeels.METAL;

		return metal;
	}


	@Override
	protected BasePanel<ApplicationModelBean> newMainComponent() {
		return new MainPanel();
	}

	public MainPanel getMainPanel(){
		return (MainPanel) getMainComponent();
	}
}
