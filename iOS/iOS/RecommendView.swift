//
//  RecommendView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct RecommendView: View {
    var body: some View {
		ZStack {
			Rectangle()
				.foregroundColor(.orange)
			Text("추천 화면")
		}
    }
}

struct RecommendView_Previews: PreviewProvider {
    static var previews: some View {
        RecommendView()
    }
}
