// =========================================
// LOCAL DEV
// =========================================
export const HOST = 'localhost';
export const PORT = '9595';
// =========================================

export const SECURE = false;

export const getEndpoint = (isHttps) => {
    return `${isHttps ? 'https' : 'http'}://${HOST}:${PORT}/TECHNICAL_ASSESSMENT_V1/api/v1`;
};
