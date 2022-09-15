<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes"></xsl:output>
	<xsl:template match="/">
		<xsl:element name="Shipment">
			<xsl:element name="ServiceVal">
				<xsl:element name="HostServiceType">
					<xsl:element name="HostNaming">
						<xsl:element name="HostName">
							<xsl:element name="Carrier">
								<xsl:value-of
									select="Shipment/Service/HostServiceType/HostNaming/HostName/Carrier"></xsl:value-of>
							</xsl:element>
							<xsl:element name="Service">
								<xsl:value-of
									select="Shipment/Service/HostServiceType/HostNaming/HostName/Service"></xsl:value-of>
							</xsl:element>
							<xsl:element name="Type"></xsl:element>
							<xsl:element name="AncillaryEndorsement"></xsl:element>
							<xsl:element name="HubId"></xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="Shipper">
				<xsl:element name="shipper_id">
					<xsl:value-of select="Shipment/Shipper/shipper_id"></xsl:value-of>
				</xsl:element>
			</xsl:element>
			<xsl:element name="Sender">
				<xsl:element name="Contact">
					<xsl:element name="CompanyName">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/CompanyName"></xsl:value-of>
					</xsl:element>
					<xsl:element name="PersonName">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/PersonName"></xsl:value-of>
					</xsl:element>
					<xsl:element name="PhoneNumber">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/PhoneNumber"></xsl:value-of>
					</xsl:element>
				</xsl:element>
				<xsl:element name="Address">
					<xsl:element name="StreetLine1">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/StreetLine1"></xsl:value-of>
					</xsl:element>
					<xsl:element name="StreetLine2">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/StreetLine2"></xsl:value-of>
					</xsl:element>
					<xsl:element name="City">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/City"></xsl:value-of>
					</xsl:element>
					<xsl:element name="StateOrProvinceCode">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/StateOrProvinceCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="PostalCode">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/PostalCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="CountryCode">
						<xsl:value-of
							select="Shipment/ShipFromAddress/FromContactAndAddress/CountryCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="ResidentialAddressIndicator">
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="Recipient">


				<xsl:element name="Contact">
					<xsl:element name="PersonName">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/PersonName"></xsl:value-of>
					</xsl:element>
					<xsl:element name="CompanyName">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/CompanyName"></xsl:value-of>
					</xsl:element>

					<xsl:element name="PhoneNumber">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/PhoneNumber"></xsl:value-of>
					</xsl:element>
				</xsl:element>
				<xsl:element name="Address">
					<xsl:element name="StreetLine1">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/StreetLine1"></xsl:value-of>
					</xsl:element>
					<xsl:element name="StreetLine2">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/StreetLine2"></xsl:value-of>
					</xsl:element>
					<xsl:element name="City">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/City"></xsl:value-of>
					</xsl:element>
					<xsl:element name="StateOrProvinceCode">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/StateOrProvinceCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="PostalCode">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/PostalCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="CountryCode">
						<xsl:value-of
							select="Shipment/ShipToAddress/ToContactAndAddress/CountryCode"></xsl:value-of>
					</xsl:element>
					<xsl:element name="ResidentialAddressIndicator">
					<xsl:value-of select="Shipment/ShipToAddress/ToContactAndAddress/ResidentialAddressIndicator"></xsl:value-of>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="Packages">
				<xsl:element name="PackageCount">
					<xsl:value-of select="Shipment/Packages/PackageCount"></xsl:value-of>
				</xsl:element>
				<xsl:for-each select="Shipment/Packages/Package">
				<xsl:element name="Package">
					<xsl:element name="DropOffTime">
						<xsl:value-of
							select="DropOffTime"></xsl:value-of>
					</xsl:element>
					<xsl:element name="ShipDate">
						<xsl:value-of
							select="ShipDate"></xsl:value-of>
					</xsl:element>
					<xsl:element name="PackagingType">
						<xsl:element name="PackagingTypeCode">
							<xsl:value-of
								select="PackagingType/PackagingTypeCode"></xsl:value-of>
						</xsl:element>
					</xsl:element>
					<xsl:element name="PackageCount">
						<xsl:value-of select="PackageCount"></xsl:value-of>
					</xsl:element>
					<xsl:element name="Weight">
						<xsl:element name="Units">
							<xsl:value-of
								select="Weight/WeightUnitOfMeasurement/WeightCode"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Value">
							<xsl:value-of
								select="Weight/Weight"></xsl:value-of>
						</xsl:element>
					</xsl:element>
					<xsl:element name="Dimensions">
						<xsl:element name="Length">
							<xsl:value-of
								select="Dimensions/Length"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Width">
							<xsl:value-of
								select="Dimensions/Width"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Height">
							<xsl:value-of
								select="Dimensions/Height"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Units">
							<xsl:value-of
								select="Dimensions/Units"></xsl:value-of>
						</xsl:element>
					</xsl:element>
				</xsl:element>
				</xsl:for-each>
			</xsl:element>
			<xsl:element name="PaymentInformation">
				<xsl:element name="ShipmentCharge">
					<xsl:element name="Type">
						<xsl:value-of
							select="Shipment/PaymentInformation/ShipmentCharge/Type"></xsl:value-of>
					</xsl:element>
					<xsl:element name="BillShipper">
						<xsl:element name="AccountNumber">
							<xsl:value-of
								select="Shipment/PaymentInformation/ShipmentCharge/BillShipper/AccountNumber"></xsl:value-of>
						</xsl:element>
						<xsl:element name="ShipperAddress">
							<xsl:element name="PostalCode">
							</xsl:element>
							<xsl:element name="CountryCode">
								<xsl:value-of
									select="Shipment/PaymentInformation/ShipmentCharge/BillShipper/CreditCard/ShipperAddress/CountryCode"></xsl:value-of>
							</xsl:element>
						</xsl:element>
					</xsl:element>
					<xsl:element name="BillThirdParty">
						<xsl:element name="AccountNumber"></xsl:element>
						<xsl:element name="ThirdPartyAddress">
							<xsl:element name="PostalCode"></xsl:element>
							<xsl:element name="CountryCode">
								<xsl:value-of
									select="Shipment/PaymentInformation/ShipmentCharge/BillShipper/CreditCard/ShipperAddress/CountryCode"></xsl:value-of>
							</xsl:element>
						</xsl:element>
					</xsl:element>
					<xsl:element name="BillReceiver">
						<xsl:element name="AccountNumber"></xsl:element>
						<xsl:element name="ReceiverAddress">
							<xsl:element name="PostalCode"></xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:element name="LabelSpecification">
				<xsl:element name="ImageType">
					<xsl:value-of
						select="Shipment/LabelSpecification/ImageType"></xsl:value-of>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>