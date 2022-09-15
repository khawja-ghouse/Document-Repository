<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:fi="http://fedex.com/ws/ship/v17"
	exclude-result-prefixes="SOAP-ENV fi">
	<xsl:output method="xml" version="1.0" />
	<xsl:template match="/">
		<ShipReply>
			<Notification>
				<xsl:value-of
					select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:HighestSeverity"></xsl:value-of>
			</Notification>
			<Code>
				<xsl:value-of
					select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:Notifications/fi:Code"></xsl:value-of>
			</Code>
			<Message>
				<xsl:value-of
					select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:Notifications/fi:Message"></xsl:value-of>
			</Message>
			<CompletedShipmentDetail>
				<Carrier>
					<xsl:value-of
						select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:MasterTrackingId/fi:TrackingIdType"></xsl:value-of>
				</Carrier>
				<ServiceType>
					<xsl:text>Only Service code is available</xsl:text>
				</ServiceType>
				<CommitDetails>
					<CommitTimestamp>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:OperationalDetail/fi:TransitTime"></xsl:value-of>
					</CommitTimestamp>
				</CommitDetails>
				<SequenceNumber>
					<xsl:value-of
						select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:CompletedPackageDetails/fi:SequenceNumber"></xsl:value-of>
				</SequenceNumber>
				<MasterTrackingId>
					<TrackingNumber>
						<xsl:text>No MasterTrackingId</xsl:text>
					</TrackingNumber>
				</MasterTrackingId>
				<TrackingIds>
					<TrackingNumber>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:MasterTrackingId/fi:TrackingNumber"></xsl:value-of>
					</TrackingNumber>
				</TrackingIds>
				<ManifestMsn>
					<xsl:text>Not Available</xsl:text>
				</ManifestMsn>
				<Label>
					<Type>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:CompletedPackageDetails/fi:Label/fi:Type"></xsl:value-of>
					</Type>
					<ImageType>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:CompletedPackageDetails/fi:Label/fi:ImageType"></xsl:value-of>
					</ImageType>
					<Resolution>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:CompletedPackageDetails/fi:Label/fi:Resolution"></xsl:value-of>
					</Resolution>
					<Image>
						<xsl:value-of
							select="SOAP-ENV:Envelope/SOAP-ENV:Body/fi:ProcessShipmentReply/fi:CompletedShipmentDetail/fi:CompletedPackageDetails/fi:Label//fi:Parts/fi:Image"></xsl:value-of>
					</Image>
				</Label>
			</CompletedShipmentDetail>
		</ShipReply>
	</xsl:template>
</xsl:stylesheet>