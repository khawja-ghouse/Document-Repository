<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fi="http://fedex.com/ws/ship/v17"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<xsl:template match="/">
		<xsl:element name="soapenv:Envelope">
			<xsl:element name="soapenv:Body">
				<xsl:element name="ProcessShipmentRequest">
					<xsl:element name="WebAuthenticationDetail">
						<xsl:element name="UserCredential">
							<xsl:element name="Key">
								<xsl:value-of
									select="Shipment/WebAuthenticationDetail/UserCredential/Key"></xsl:value-of>
							</xsl:element>
							<xsl:element name="Password">
								<xsl:value-of
									select="Shipment/WebAuthenticationDetail/UserCredential/Password"></xsl:value-of>
							</xsl:element>
						</xsl:element>
					</xsl:element>
					<xsl:element name="ClientDetail">
						<xsl:element name="AccountNumber">
							<xsl:value-of
								select="Shipment/ClientDetail/AccountNumber"></xsl:value-of>
						</xsl:element>
						<xsl:element name="MeterNumber">
							<xsl:value-of
								select="Shipment/ClientDetail/MeterNumber"></xsl:value-of>
						</xsl:element>
					</xsl:element>
					<xsl:element name="Version">
						<xsl:element name="ServiceId">
							<xsl:value-of select="Shipment/Version/ServiceId"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Major">
							<xsl:value-of select="Shipment/Version/Major"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Intermediate">
							<xsl:value-of select="Shipment/Version/Intermediate"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Minor">
							<xsl:value-of select="Shipment/Version/Minor"></xsl:value-of>
						</xsl:element>
					</xsl:element>
					<xsl:element name="RequestedShipment">
						<xsl:element name="ShipTimestamp">
							<xsl:value-of
								select="Shipment/Packages/Package/ShipDate"></xsl:value-of>
						</xsl:element>
						<xsl:element name="DropoffType">
							<xsl:value-of
								select="Shipment/RequestedShipment/DropoffType"></xsl:value-of>
						</xsl:element>
						<xsl:element name="ServiceType">
							<xsl:value-of
								select="Shipment/ServiceVal/HostServiceType/HostNaming/HostName/Service"></xsl:value-of>
						</xsl:element>
						<xsl:element name="PackagingType">
							<xsl:value-of
								select="Shipment/RequestedShipment/PackagingType"></xsl:value-of>
						</xsl:element>
						<xsl:element name="Shipper">
							<xsl:element name="Contact">
								<xsl:element name="PersonName">
									<xsl:value-of
										select="Shipment/Sender/Contact/PersonName"></xsl:value-of>
								</xsl:element>
								<xsl:element name="CompanyName">
									<xsl:value-of
										select="Shipment/Sender/Contact/CompanyName"></xsl:value-of>
								</xsl:element>
								<xsl:element name="PhoneNumber">
									<xsl:value-of
										select="Shipment/Sender/Contact/PhoneNumber"></xsl:value-of>
								</xsl:element>
							</xsl:element>
							<xsl:element name="Address">
								<xsl:element name="StreetLines">
									<xsl:value-of
										select="Shipment/Sender/Address/StreetLine1"></xsl:value-of>
								</xsl:element>
								<xsl:element name="StreetLines">
									<xsl:value-of
										select="Shipment/Sender/Address/StreetLine2"></xsl:value-of>
								</xsl:element>
								<xsl:element name="City">
									<xsl:value-of
										select="Shipment/Sender/Address/City"></xsl:value-of>
								</xsl:element>
								<xsl:element name="StateOrProvinceCode">
									<xsl:value-of
										select="Shipment/Sender/Address/StateOrProvinceCode"></xsl:value-of>
								</xsl:element>
								<xsl:element name="PostalCode">
									<xsl:value-of
										select="Shipment/Sender/Address/PostalCode"></xsl:value-of>
								</xsl:element>
								<xsl:element name="CountryCode">
									<xsl:value-of
										select="Shipment/Sender/Address/CountryCode"></xsl:value-of>
								</xsl:element>
							</xsl:element>
						</xsl:element>
						<xsl:element name="Recipient">
							<xsl:element name="Contact">
								<xsl:element name="PersonName">
									<xsl:value-of
										select="Shipment/Recipient/Contact/PersonName"></xsl:value-of>
								</xsl:element>

								<xsl:element name="CompanyName">
									<xsl:value-of
										select="Shipment/Recipient/Contact/CompanyName"></xsl:value-of>
								</xsl:element>
								<xsl:element name="PhoneNumber">
									<xsl:value-of
										select="Shipment/Recipient/Contact/PhoneNumber"></xsl:value-of>
								</xsl:element>
							</xsl:element>
							<xsl:element name="Address">
								<xsl:element name="StreetLines">
									<xsl:value-of
										select="Shipment/Recipient/Address/StreetLine1"></xsl:value-of>
								</xsl:element>
								<xsl:element name="StreetLines">
									<xsl:value-of
										select="Shipment/Recipient/Address/StreetLine2"></xsl:value-of>
								</xsl:element>
								<xsl:element name="City">
									<xsl:value-of
										select="Shipment/Recipient/Address/City"></xsl:value-of>
								</xsl:element>
								<xsl:element name="StateOrProvinceCode">
									<xsl:value-of
										select="Shipment/Recipient/Address/StateOrProvinceCode"></xsl:value-of>
								</xsl:element>
								<xsl:element name="PostalCode">
									<xsl:value-of
										select="Shipment/Recipient/Address/PostalCode"></xsl:value-of>
								</xsl:element>
								<xsl:element name="CountryCode">
									<xsl:value-of
										select="Shipment/Recipient/Address/CountryCode"></xsl:value-of>
								</xsl:element>
								<xsl:element name="Residential">
									<xsl:text>false</xsl:text>
								</xsl:element>
							</xsl:element>
						</xsl:element>
						<xsl:element name="ShippingChargesPayment">
							<xsl:element name="PaymentType">
								<xsl:value-of
									select="Shipment/ShippingChargesPayment/PaymentType"></xsl:value-of>
							</xsl:element>
							<xsl:element name="Payor">
								<xsl:element name="ResponsibleParty">
									<xsl:element name="AccountNumber">
										<xsl:value-of
											select="Shipment/ClientDetail/AccountNumber"></xsl:value-of>
									</xsl:element>
									<xsl:element name="Address">
										<xsl:element name="PostalCode"></xsl:element>
										<xsl:element name="CountryCode">
											<xsl:value-of
												select="Shipment/PaymentInformation/ShipmentCharge/BillShipper/ShipperAddress/CountryCode"></xsl:value-of>
										</xsl:element>
									</xsl:element>
								</xsl:element>
							</xsl:element>
						</xsl:element>
						<xsl:element name="LabelSpecification">
							<xsl:element name="LabelFormatType">
								<xsl:value-of
									select="Shipment/LabelSpecification/LabelFormatType"></xsl:value-of>
							</xsl:element>
							<xsl:element name="ImageType">
								<xsl:text>ZPLII</xsl:text>
							</xsl:element>
						</xsl:element>
						<xsl:element name="PackageCount">
							<xsl:value-of
								select="Shipment/Packages/PackageCount"></xsl:value-of>
						</xsl:element>
						<xsl:element name="RequestedPackageLineItems">
							<xsl:element name="Weight">
								<xsl:element name="Units">
									<xsl:value-of
										select="Shipment/Packages/Package/Weight/Units"></xsl:value-of>
								</xsl:element>
								<xsl:element name="Value">
									<xsl:value-of
										select="Shipment/Packages/Package/Weight/Value"></xsl:value-of>
								</xsl:element>
							</xsl:element>
							<xsl:element name="Dimensions">
								<xsl:element name="Length">
									<xsl:value-of
										select="Shipment/Packages/Package/Dimensions/Length"></xsl:value-of>
								</xsl:element>
								<xsl:element name="Width">
									<xsl:value-of
										select="Shipment/Packages/Package/Dimensions/Width"></xsl:value-of>
								</xsl:element>
								<xsl:element name="Height">
									<xsl:value-of
										select="Shipment/Packages/Package/Dimensions/Height"></xsl:value-of>
								</xsl:element>
								<xsl:element name="Units">
									<xsl:value-of
										select="Shipment/Packages/Package/Dimensions/Units"></xsl:value-of>
								</xsl:element>
							</xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>