<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:element name="key">
			<xsl:for-each select="moca-results/data/row">
				<xsl:value-of select="field"></xsl:value-of>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>