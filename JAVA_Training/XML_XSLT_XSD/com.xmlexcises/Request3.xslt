<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:key="http://schemas.datacontract.org/2004/07/Key2Act.OnPremiseServices.TTTrx.eTimeTrackService"
	xmlns:tem="http://tempuri.org/">
	<xsl:output method="xml" version="1.0" indent="yes" />
	<xsl:template match="/">
		<soap:Envelope>
			<soap:Header />
			<soap:Body>
				<tem:InsertTransaction>
					<tem:Tenant>
						<xsl:value-of select="InsertTransaction/Tenant"></xsl:value-of>
					</tem:Tenant>
					<tem:Companydbname>
						<xsl:value-of
							select="InsertTransaction/Companydbname"></xsl:value-of>
					</tem:Companydbname>

					<tem:trx>
						<key:aCTINDXField>
						<xsl:value-of select="InsertTransaction/trx/aCTINDXField"></xsl:value-of>
						</key:aCTINDXField>
						<key:aDRSCODEField />
						<key:aSSETIDField />
						<key:aSSETIDSUFField>
							<xsl:value-of select="InsertTransaction/trx/aSSETIDSUFField"></xsl:value-of>
						</key:aSSETIDSUFField>
						<key:aSSETINDEXField>
							<xsl:value-of select="InsertTransaction/trx/aSSETINDEXField"></xsl:value-of>
						</key:aSSETINDEXField>
						<key:appointmentField />
						<key:bACHNUMBField>
							<xsl:value-of select="InsertTransaction/trx/bACHNUMBField"></xsl:value-of>
						</key:bACHNUMBField>
						<key:bCHSOURCField />
						<key:basePayRateAmountField>
							<xsl:value-of select="InsertTransaction/trx/basePayRateAmountField"></xsl:value-of>
						</key:basePayRateAmountField>
						<key:billing_AmountField>
							<xsl:value-of select="InsertTransaction/trx/billing_AmountField"></xsl:value-of>
						</key:billing_AmountField>
						<key:cOMPTRNMField>
							<xsl:value-of select="InsertTransaction/trx/cOMPTRNMField"></xsl:value-of>
						</key:cOMPTRNMField>
						<key:cOMPTRTPField>
							<xsl:value-of select="InsertTransaction/trx/cOMPTRTPField"></xsl:value-of>
						</key:cOMPTRTPField>
						<key:cUSTNMBRField />
						<key:cashFringeField>
							<xsl:value-of select="InsertTransaction/trx/cashFringeField"></xsl:value-of>
						</key:cashFringeField>
						<key:certified_PayrollField>
							<xsl:value-of select="InsertTransaction/trx/certified_PayrollField"></xsl:value-of>
						</key:certified_PayrollField>
						<key:cost_Code_Act_Cost_TTDField>
							<xsl:value-of select="InsertTransaction/trx/cost_Code_Act_Cost_TTDField"></xsl:value-of>
						</key:cost_Code_Act_Cost_TTDField>
						<key:cost_Code_AliasField />
						<key:cost_Code_Number_1Field />
						<key:cost_Code_Number_2Field />
						<key:cost_Code_Number_3Field />
						<key:cost_Code_Number_4Field />
						<key:cost_Decimal_PlacesField><xsl:value-of select="InsertTransaction/trx/cost_Decimal_PlacesField"></xsl:value-of></key:cost_Decimal_PlacesField>
						<key:cost_ElementField><xsl:value-of select="InsertTransaction/trx/cost_ElementField"></xsl:value-of></key:cost_ElementField>
						<key:cost_Per_UnitField><xsl:value-of select="InsertTransaction/trx/cost_Per_UnitField"></xsl:value-of></key:cost_Per_UnitField>
						<key:dAYSWRDKField><xsl:value-of select="InsertTransaction/trx/dAYSWRDKField"></xsl:value-of></key:dAYSWRDKField>
						<key:dEPRTMNTField />
						<key:dEX_ROW_IDField><xsl:value-of select="InsertTransaction/trx/dEX_ROW_IDField"></xsl:value-of></key:dEX_ROW_IDField>
						<key:dYOFWEEKField><xsl:value-of select="InsertTransaction/trx/dYOFWEEKField"></xsl:value-of></key:dYOFWEEKField>
						<key:document_SourceField />
						<key:eMPLOYIDField><xsl:value-of select="InsertTransaction/trx/eMPLOYIDField"></xsl:value-of></key:eMPLOYIDField>
						<key:eQSEQUIPIDField />
						<key:eQS_Cost_CodeField />
						<key:employeeFringeField><xsl:value-of select="InsertTransaction/trx/employeeFringeField"></xsl:value-of></key:employeeFringeField>
						<key:employeeHomeRCRateField><xsl:value-of select="InsertTransaction/trx/employeeHomeRCRateField"></xsl:value-of></key:employeeHomeRCRateField>
						<key:employeeRateField><xsl:value-of select="InsertTransaction/trx/employeeRateField"></xsl:value-of></key:employeeRateField>
						<key:equipment_IDField />
						<key:est_Pct_Complete_to_DateField><xsl:value-of select="InsertTransaction/trx/est_Pct_Complete_to_DateField"></xsl:value-of>
						</key:est_Pct_Complete_to_DateField>
						<key:fEDCLSSCDField />
						<key:fridayField><xsl:value-of select="InsertTransaction/trx/fridayField"></xsl:value-of></key:fridayField>
						<key:iTEMDESCField />
						<key:iTEMNMBRField />
						<key:jOBTITLEField />
						<key:jobTransactionRCRateField><xsl:value-of select="InsertTransaction/trx/jobTransactionRCRateField"></xsl:value-of></key:jobTransactionRCRateField>
						<key:lNSEQNBRField><xsl:value-of select="InsertTransaction/trx/lNSEQNBRField"></xsl:value-of></key:lNSEQNBRField>
						<key:lOCALTAXField />
						<key:lOCNCODEField />
						<key:labor_Fixed_OHField><xsl:value-of select="InsertTransaction/trx/labor_Fixed_OHField"></xsl:value-of></key:labor_Fixed_OHField>
						<key:labor_OH_PercentageField><xsl:value-of select="InsertTransaction/trx/labor_OH_PercentageField"></xsl:value-of></key:labor_OH_PercentageField>
						<key:mDFUSRIDField />
						<key:mODIFDTField><xsl:value-of select="InsertTransaction/trx/mODIFDTField"></xsl:value-of></key:mODIFDTField>
						<key:modified_TimeField><xsl:value-of select="InsertTransaction/trx/modified_TimeField"></xsl:value-of></key:modified_TimeField>
						<key:mondayField><xsl:value-of select="InsertTransaction/trx/mondayField"></xsl:value-of></key:mondayField>
						<key:noteField />
						<key:oH_AmountField><xsl:value-of select="InsertTransaction/trx/oH_AmountField"></xsl:value-of></key:oH_AmountField>
						<key:overhead_1_Cst_Dec_PlcsField><xsl:value-of select="InsertTransaction/trx/overhead_1_Cst_Dec_PlcsField"></xsl:value-of>
						</key:overhead_1_Cst_Dec_PlcsField>
						<key:overhead_1_Cst_Per_UnitField><xsl:value-of select="InsertTransaction/trx/overhead_1_Cst_Per_UnitField"></xsl:value-of>
						</key:overhead_1_Cst_Per_UnitField>
						<key:overhead_1_Pct_RateField><xsl:value-of select="InsertTransaction/trx/overhead_1_Pct_RateField"></xsl:value-of></key:overhead_1_Pct_RateField>
						<key:overhead_1_PercentField><xsl:value-of select="InsertTransaction/trx/overhead_1_PercentField"></xsl:value-of></key:overhead_1_PercentField>
						<key:overhead_Group_CodeField />
						<key:overhead_Units_1Field><xsl:value-of select="InsertTransaction/trx/overhead_Units_1Field"></xsl:value-of></key:overhead_Units_1Field>
						<key:ovrhd_1_Unit_Dec_PlacesField><xsl:value-of select="InsertTransaction/trx/ovrhd_1_Unit_Dec_PlacesField"></xsl:value-of>
						</key:ovrhd_1_Unit_Dec_PlacesField>
						<key:pAYRTAMTField><xsl:value-of select="InsertTransaction/trx/pAYRTAMTField"></xsl:value-of></key:pAYRTAMTField>
						<key:pSTGSTUSField><xsl:value-of select="InsertTransaction/trx/pSTGSTUSField"></xsl:value-of></key:pSTGSTUSField>
						<key:payroll_Pay_TypeField><xsl:value-of select="InsertTransaction/trx/payroll_Pay_TypeField"></xsl:value-of></key:payroll_Pay_TypeField>
						<key:prevailingFringeField><xsl:value-of select="InsertTransaction/trx/prevailingFringeField"></xsl:value-of></key:prevailingFringeField>
						<key:production_Actual_QtyField><xsl:value-of select="InsertTransaction/trx/production_Actual_QtyField"></xsl:value-of></key:production_Actual_QtyField>
						<key:profit_AmountField><xsl:value-of select="InsertTransaction/trx/profit_AmountField"></xsl:value-of></key:profit_AmountField>
						<key:profit_Type_NumberField><xsl:value-of select="InsertTransaction/trx/profit_Type_NumberField"></xsl:value-of></key:profit_Type_NumberField>
						<key:project_NumberField />
						<key:rATECLSSField />
						<key:sEQNUMBRField><xsl:value-of select="InsertTransaction/trx/sEQNUMBRField"></xsl:value-of></key:sEQNUMBRField>
						<key:sHFTCODEField />
						<key:sHFTPREMField><xsl:value-of select="InsertTransaction/trx/sHFTPREMField"></xsl:value-of></key:sHFTPREMField>
						<key:sTATECDField />
						<key:sUTASTATField />
						<key:sV_Language_IDField><xsl:value-of select="InsertTransaction/trx/sV_Language_IDField"></xsl:value-of></key:sV_Language_IDField>
						<key:saturdayField><xsl:value-of select="InsertTransaction/trx/saturdayField"></xsl:value-of></key:saturdayField>
						<key:sundayField><xsl:value-of select="InsertTransaction/trx/sundayField"></xsl:value-of></key:sundayField>
						<key:tRXBEGDTField><xsl:value-of select="InsertTransaction/trx/tRXBEGDTField"></xsl:value-of></key:tRXBEGDTField>
						<key:tRXDSCRNField />
						<key:tRXENDDTField><xsl:value-of select="InsertTransaction/trx/tRXENDDTField"></xsl:value-of></key:tRXENDDTField>
						<key:tRXHRUNTField><xsl:value-of select="InsertTransaction/trx/tRXHRUNTField"></xsl:value-of></key:tRXHRUNTField>
						<key:tRXQTYField><xsl:value-of select="InsertTransaction/trx/tRXQTYField"></xsl:value-of></key:tRXQTYField>
						<key:tRX_OriginField />
						<key:tRX_QTY_PRField><xsl:value-of select="InsertTransaction/trx/tRX_QTY_PRField"></xsl:value-of></key:tRX_QTY_PRField>
						<key:tRX_VerifiedField><xsl:value-of select="InsertTransaction/trx/tRX_VerifiedField"></xsl:value-of></key:tRX_VerifiedField>
						<key:task_CodeField />
						<key:thursdayField><xsl:value-of select="InsertTransaction/trx/thursdayField"></xsl:value-of></key:thursdayField>
						<key:time_InField><xsl:value-of select="InsertTransaction/trx/time_InField"></xsl:value-of></key:time_InField>
						<key:time_In_DateField><xsl:value-of select="InsertTransaction/trx/time_In_DateField"></xsl:value-of></key:time_In_DateField>
						<key:time_OutField><xsl:value-of select="InsertTransaction/trx/time_OutField"></xsl:value-of></key:time_OutField>
						<key:time_Out_DateField><xsl:value-of select="InsertTransaction/trx/time_Out_DateField"></xsl:value-of></key:time_Out_DateField>
						<key:time_ZoneField />
						<key:transaction_Pay_PeriodField><xsl:value-of select="InsertTransaction/trx/transaction_Pay_PeriodField"></xsl:value-of>
						</key:transaction_Pay_PeriodField>
						<key:tuesdayField><xsl:value-of select="InsertTransaction/trx/tuesdayField"></xsl:value-of></key:tuesdayField>
						<key:uNIONCDField />
						<key:uOFMField />
						<key:uPRTRXCDField><xsl:value-of select="InsertTransaction/trx/uPRTRXCDField"></xsl:value-of></key:uPRTRXCDField>
						<key:uSERDEF1Field />
						<key:uSERDEF2Field />
						<key:uSERIDField />
						<key:uSRDAT01Field><xsl:value-of select="InsertTransaction/trx/uSRDAT01Field"></xsl:value-of></key:uSRDAT01Field>
						<key:uSRDAT02Field><xsl:value-of select="InsertTransaction/trx/uSRDAT02Field"></xsl:value-of></key:uSRDAT02Field>
						<key:unit_Decimal_PlacesField><xsl:value-of select="InsertTransaction/trx/unit_Decimal_PlacesField"></xsl:value-of></key:unit_Decimal_PlacesField>
						<key:user_Def_Integer_1Field><xsl:value-of select="InsertTransaction/trx/user_Def_Integer_1Field"></xsl:value-of></key:user_Def_Integer_1Field>
						<key:user_Def_Integer_2Field><xsl:value-of select="InsertTransaction/trx/user_Def_Integer_2Field"></xsl:value-of></key:user_Def_Integer_2Field>
						<key:user_Define_1Field />
						<key:user_Define_2Field />
						<key:user_Defined_CB_1Field><xsl:value-of select="InsertTransaction/trx/user_Defined_CB_1Field"></xsl:value-of></key:user_Defined_CB_1Field>
						<key:user_Defined_CB_2Field><xsl:value-of select="InsertTransaction/trx/user_Defined_CB_2Field"></xsl:value-of></key:user_Defined_CB_2Field>
						<key:user_Defined_CB_3Field><xsl:value-of select="InsertTransaction/trx/user_Defined_CB_3Field"></xsl:value-of></key:user_Defined_CB_3Field>
						<key:user_Defined_CB_4Field><xsl:value-of select="InsertTransaction/trx/user_Defined_CB_4Field"></xsl:value-of></key:user_Defined_CB_4Field>
						<key:user_Defined_Date_3Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Date_3Field"></xsl:value-of>
						</key:user_Defined_Date_3Field>
						<key:user_Defined_Date_4Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Date_4Field"></xsl:value-of>
						</key:user_Defined_Date_4Field>
						<key:user_Defined_Dollar_1Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Dollar_1Field"></xsl:value-of></key:user_Defined_Dollar_1Field>
						<key:user_Defined_Dollar_2Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Dollar_2Field"></xsl:value-of></key:user_Defined_Dollar_2Field>
						<key:user_Defined_Dollar_3Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Dollar_3Field"></xsl:value-of></key:user_Defined_Dollar_3Field>
						<key:user_Defined_Dollar_4Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Dollar_4Field"></xsl:value-of></key:user_Defined_Dollar_4Field>
						<key:user_Defined_Integer_3Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Integer_3Field"></xsl:value-of>
						</key:user_Defined_Integer_3Field>
						<key:user_Defined_Integer_4Field><xsl:value-of select="InsertTransaction/trx/user_Defined_Integer_4Field"></xsl:value-of>
						</key:user_Defined_Integer_4Field>
						<key:vARDBAMTField><xsl:value-of select="InsertTransaction/trx/vARDBAMTField"></xsl:value-of></key:vARDBAMTField>
						<key:vENDORIDField />
						<key:wKSWRKDField><xsl:value-of select="InsertTransaction/trx/wKSWRKDField"></xsl:value-of></key:wKSWRKDField>
						<key:wO_Task_IDField />
						<key:wRKRCOMPField />
						<key:wSReserved_CB10Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB10Field>
						<key:wSReserved_CB1Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB1Field>
						<key:wSReserved_CB2Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB2Field>
						<key:wSReserved_CB3Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB3Field>
						<key:wSReserved_CB4Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB4Field>
						<key:wSReserved_CB5Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB5Field>
						<key:wSReserved_CB6Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB6Field>
						<key:wSReserved_CB7Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB7Field>
						<key:wSReserved_CB8Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB8Field>
						<key:wSReserved_CB9Field><xsl:value-of select="InsertTransaction/trx/wSReserved_CB10Field"></xsl:value-of></key:wSReserved_CB9Field>
						<key:wS_Cost_CodeField><xsl:value-of select="InsertTransaction/trx/wS_Cost_CodeField"></xsl:value-of></key:wS_Cost_CodeField>
						<key:wS_Cost_TypeField><xsl:value-of select="InsertTransaction/trx/wS_Cost_TypeField"></xsl:value-of></key:wS_Cost_TypeField>
						<key:wS_Extended_CostField><xsl:value-of select="InsertTransaction/trx/wS_Extended_CostField"></xsl:value-of></key:wS_Extended_CostField>
						<key:wS_Job_NumberField><xsl:value-of select="InsertTransaction/trx/wS_Job_NumberField"></xsl:value-of></key:wS_Job_NumberField>
						<key:wS_ModuleField />
						<key:wS_Posting_StatusField><xsl:value-of select="InsertTransaction/trx/wS_Posting_StatusField"></xsl:value-of></key:wS_Posting_StatusField>
						<key:wS_Transaction_DateField><xsl:value-of select="InsertTransaction/trx/wS_Transaction_DateField"></xsl:value-of>
						</key:wS_Transaction_DateField>
						<key:wS_Transaction_StatusField><xsl:value-of select="InsertTransaction/trx/wS_Transaction_StatusField"></xsl:value-of></key:wS_Transaction_StatusField>
						<key:wS_Transaction_TypeField><xsl:value-of select="InsertTransaction/trx/wS_Transaction_TypeField"></xsl:value-of>
						</key:wS_Transaction_TypeField>
						<key:wednesdayField><xsl:value-of select="InsertTransaction/trx/wednesdayField"></xsl:value-of></key:wednesdayField>
						<key:wennsoft_AffiliateField />
						<key:wennsoft_BranchField />
						<key:wennsoft_RegionField />
					</tem:trx>
				</tem:InsertTransaction>
			</soap:Body>
		</soap:Envelope>
	</xsl:template>
</xsl:stylesheet>