package com.dhanush;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;

public class Form extends javax.swing.JFrame {

	public Form() {
		initComponents();
		ConstrainedTextField[] fieldsInit = { principalField, interestField, periodField };
		fields = fieldsInit;
		paymentsButton.setVisible(false);
	}

	private void initComponents() {
		leftPanel = new javax.swing.JPanel();
		principalLabel = new javax.swing.JLabel();
		interestLabel = new javax.swing.JLabel();
		periodLabel = new javax.swing.JLabel();
		principalField = new ConstrainedTextField(1000, 1_000_000);
		interestField = new ConstrainedTextField(1, 30);
		periodField = new ConstrainedTextField(1, 30);
		mortgageButton = new javax.swing.JButton();
		mortgage = new javax.swing.JLabel();
		paymentsButton = new javax.swing.JButton();
		listPanel = new javax.swing.JScrollPane();
		paymentschedule = new javax.swing.JList<>();
		paymentScheduleLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));
		leftPanel.setPreferredSize(new java.awt.Dimension(340, 388));

		principalLabel.setLabelFor(principalField);
		principalLabel.setText("Loan Amount:");

		interestLabel.setLabelFor(interestField);
		interestLabel.setText("Interest Rate:");

		periodLabel.setLabelFor(periodField);
		periodLabel.setText("Period:");

		principalField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				textFieldKeyReleased(evt);
			}
		});

		interestField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				textFieldKeyReleased(evt);
			}
		});

		periodField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				textFieldKeyReleased(evt);
			}
		});

		mortgageButton.setText("Calculate Mortgage");
		mortgageButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mortgageButtonActionPerformed(evt);
			}
		});

		mortgage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		paymentsButton.setText("Get Payment Schedule");
		paymentsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				paymentsButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
		leftPanel.setLayout(leftPanelLayout);
		leftPanelLayout.setHorizontalGroup(
				leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(leftPanelLayout.createSequentialGroup()
								.addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout
												.createSequentialGroup()
												.addGap(23, 23, 23)
												.addGroup(leftPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(leftPanelLayout.createSequentialGroup()
																.addComponent(principalLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(principalField))
														.addGroup(leftPanelLayout.createSequentialGroup()
																.addComponent(periodLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(periodField,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 203,
																		Short.MAX_VALUE))
														.addGroup(leftPanelLayout.createSequentialGroup()
																.addComponent(interestLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(interestField,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 203,
																		Short.MAX_VALUE))))
										.addGroup(leftPanelLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(mortgageButton, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(mortgage, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(leftPanelLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(paymentsButton, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addContainerGap()));
		leftPanelLayout.setVerticalGroup(
				leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(leftPanelLayout.createSequentialGroup()
								.addGap(47, 47, 47)
								.addGroup(
										leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(principalLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														30, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(principalField, javax.swing.GroupLayout.PREFERRED_SIZE,
														30, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(39, 39, 39)
								.addGroup(
										leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(interestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(41, 41, 41)
								.addGroup(
										leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(periodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(31, 31, 31)
								.addComponent(mortgageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mortgage, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(paymentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		listPanel.setViewportView(paymentschedule);

		paymentScheduleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		paymentScheduleLabel.setText("Payment Schedule");
		paymentScheduleLabel.setToolTipText("");
		paymentScheduleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 244,
												Short.MAX_VALUE)
										.addComponent(paymentScheduleLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 391,
												Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(paymentScheduleLabel,
														javax.swing.GroupLayout.PREFERRED_SIZE, 35,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));

		pack();
	}

	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		var field = (ConstrainedTextField) evt.getSource();
		var border = field.isInRange() ? greenBorder : redBorder;
		field.setBorder(border);
	}

	private void mortgageButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (fieldsAreValid()) {
			int principal = (int) principalField.getValue();
			float interest = (float) interestField.getValue();
			byte period = (byte) periodField.getValue();

			calculator = new MortgageCalculator(principal, interest, period);
			var mortgageFormatted = currency.format(calculator.calculateMortgage());
			mortgage.setText("Mortgage: " + mortgageFormatted);

			paymentsButton.setVisible(true);
		} else {
			mortgage.setText("Fields are InValid!!!");
			paymentsButton.setVisible(false);
		}
	}

	private void paymentsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultListModel<String> model = new DefaultListModel<>();
		var payments = calculator.getPaymentSchedule();

		for (int i = 0; i < payments.length; i++)
			model.addElement("Month- " + (i + 1) + ":   " + currency.format(payments[i]));

		paymentschedule.setModel(model);
	}

	private boolean fieldsAreValid() {
		for (ConstrainedTextField field : fields)
			if (!field.isInRange())
				return false;
		return true;
	}

	private ConstrainedTextField interestField;
	private javax.swing.JLabel interestLabel;
	private javax.swing.JPanel leftPanel;
	private javax.swing.JScrollPane listPanel;
	private javax.swing.JLabel mortgage;
	private javax.swing.JButton mortgageButton;
	private javax.swing.JLabel paymentScheduleLabel;
	private javax.swing.JButton paymentsButton;
	private javax.swing.JList<String> paymentschedule;
	private ConstrainedTextField periodField;
	private javax.swing.JLabel periodLabel;
	private ConstrainedTextField principalField;
	private javax.swing.JLabel principalLabel;

	ConstrainedTextField[] fields;

	private Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 2);
	private Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
	private MortgageCalculator calculator;

	private NumberFormat currency = NumberFormat.getCurrencyInstance();
}
